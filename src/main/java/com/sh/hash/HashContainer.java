package com.sh.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 设计一个数据结构，使得如下三个操作的时间复杂度都是O(1)：
 * + insert(value)：如果数据集不包含一个数值，则把它添加到数据集；
 * + remove(value)：如果数据集包含一个数值，则把它删除；
 * + getRandom()：随机返回数据集中的一个数值，要求数据集里每个数字被返回的概率都相同。
 */
public class HashContainer<T> {
    // 保存元素的list
    private List<T> dataList;
    // 保存元素在list中的索引
    private HashMap<T, Integer> dataToLocation;

    public HashContainer() {
        // ArrayList 内部使用数组实现，可以满足getRandom()方法的需求
        dataList = new ArrayList<>();
        dataToLocation = new HashMap<>();
    }

    public boolean insert(T value) {
        if (dataToLocation.containsKey(value)) {
            return false;
        }
        dataList.add(value);
        dataToLocation.put(value, dataList.size() - 1);
        return true;
    }

    public boolean remove(T value) {
        if (!dataToLocation.containsKey(value)) {
            return false;
        }
        // 找到元素在list中的索引
        int location = dataToLocation.get(value);
        // 从list中删除元素时，如果元素在list中间位置，则删除后，为保证数组内存的连续性，
        // 则会移动其它元素填补空位，导致时间复杂度为O(n)，可以用list最后一个元素覆盖掉要删除的元素
        // 这样最后一个元素的值出现了两次，此时删除list中最后一个元素即可，这样时间复杂度为O(1)
        dataList.set(location, dataList.get(dataList.size() - 1));
        dataList.remove(dataList.size() - 1);
        // 修改list中location索引处新元素在map中的位置
        dataToLocation.put(dataList.get(location), location);
        // 从map中删除目标值
        dataToLocation.remove(value);
        return true;
    }

    public T getRandom() {
        if (dataList.size() == 0) {
            return null;
        }
        Random random = new Random();
        int i = random.nextInt(dataList.size());
        return dataList.get(i);
    }

    public static void main(String[] args) {
        HashContainer<Integer> container = new HashContainer<>();
        container.insert(1);
        container.insert(2);
        container.insert(3);
        container.insert(4);
        container.remove(2);
        Integer random = container.getRandom();
        System.out.println(random);
    }
}
