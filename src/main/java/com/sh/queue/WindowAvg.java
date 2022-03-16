package com.sh.queue;

import java.util.LinkedList;

/**
 * 计算滑动窗口内元素的平均值
 */
public class WindowAvg {
    // 窗口宽度
    int width;
    // 当前窗口范围内元素的和
    int sum;
    LinkedList<Integer> list = new LinkedList<>();

    public WindowAvg(int width) {
        this.width = width;
    }

    public float avg(int val) {
        if (list.size() >= width) {
            // 队列头部元素出队列
            int head = list.poll();
            sum -= head;
        }
        // 新元素添加到队列尾部
        list.offer(val);
        sum += val;
        // 返回平均值
        float v = sum * 1.0f / width;
        System.out.println(v);
        return v;
    }

    public static void main(String[] args) {
        WindowAvg windowAvg = new WindowAvg(3);
        windowAvg.avg(6);
        windowAvg.avg(3);
        windowAvg.avg(1);
        windowAvg.avg(2);

    }
}
