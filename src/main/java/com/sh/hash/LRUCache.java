package com.sh.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 请设计实现一个最近最少使用（Least Recently Used，LRU）缓存，要求如下两个操作的时间复杂度都是O(1)：
 * + get(key)：如果缓存中存在键值key，则返回它对应的值；否则返回-1。
 * + put(key, value)：如果缓存中之前包含键值key，将它的值设为value；否则添加键值key及对应的值value。
 * 在添加一个键值时如果缓存容量已经满了，则在添加新键值之前删除最近最少使用的键值（缓存里最长时间没有被使用过的元素）。
 * <p>
 * 用map保存键值对，可以满足get\put时间复杂度为O(1)，但是无法知道那个是最近最少使用的键值对
 * 可以额外再定义一个双向链表，节点就是键值对，如果某个键值对被访问（get\put）则将其移动到链表尾部，则表头的键值对是最近最少使用的
 * 将新的键值对添加到链表尾部，如果缓存已满，则先删除表头的键值对
 */
public class LRUCache<T, V> {
    // 保存数据
    private final Map<T, Node3<T, V>> map;
    // 缓存的容量
    private final int capacity;
    // 创建两个哨兵节点，分别在链表的头尾，方便添加、删除节点
    private final Node3<T, V> head;
    private final Node3<T, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node3<>();
        tail = new Node3<>();

        head.next = tail;
        tail.prev = head;
    }

    /**
     * 查询缓存
     *
     * @param key
     * @return
     */
    public V get(T key) {
        Node3<T, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        // 将节点移动到链表尾部
        moveToTail(node);
        return node.value;
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public void put(T key, V value) {
        if (map.containsKey(key)) {
            // 将节点移动到链表尾部
            Node3<T, V> node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            if (map.size() == capacity) {// 缓存已满
                Node3<T, V> toBeDeleted = head.next;
                // 删除头节点
                deleteNode(toBeDeleted);
                // 从map删除对应键值对
                map.remove(toBeDeleted.key);
            }
            Node3<T, V> node = new Node3<>(key, value);
            // 将新节点添加到链表尾部
            insertTail(node);
            // 保存到map
            map.put(key, node);
        }
    }

    /**
     * 将某个几点移动到链表尾部
     *
     * @param node
     */
    private void moveToTail(Node3<T, V> node) {
        // 先删掉节点，再插入到尾部
        deleteNode(node);
        insertTail(node);
    }

    /**
     * 删除某个节点
     *
     * @param node
     */
    private void deleteNode(Node3<T, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 在链表尾部插入某个节点
     *
     * @param node
     */
    private void insertTail(Node3<T, V> node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(5);
        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        cache.put(4, "4");
        cache.put(5, "5");
        cache.put(6, "6");
        cache.get(1);
        cache.get(2);
        cache.put(3, "33");
        System.out.println("---");
    }
}
