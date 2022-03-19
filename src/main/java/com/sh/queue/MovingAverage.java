package com.sh.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现如下类型MovingAverage计算滑动窗口里所有数字的平均值，该类型构造函数的参数确定滑动窗口的大小，
 * 成员函数next每次调用的时候都会往滑动窗口添加一个整数，并返回滑动窗口里所有数字的平均值。
 *
 * 例如当滑动窗口的大小为3时，第一次调用next函数往滑动窗口里添加整数1，此时窗口里只有一个数字1，因此返回平均值1。
 * 再次调用next函数添加整数2，此时窗口里有两个数字1和2，因此返回平均值1.5。
 * 第三次调用next函数添加数字3，此时有三个数字1、2、3，因此返回平均值2。
 * 第四次调用next函数添加数字4，由于受到窗口大小的限制滑动窗口最多只能由三个数字，因此第一个数字1将滑出窗口，因此窗口里包含三个数字2、3、4，返回平均值3。
 */
public class MovingAverage {
    // 窗口宽度
    int width;
    // 当前窗口范围内元素的和
    int sum;
    Queue<Integer> list;

    public MovingAverage(int width) {
        this.width = width;
        list = new LinkedList<>();
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
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.avg(6);
        movingAverage.avg(3);
        movingAverage.avg(1);
        movingAverage.avg(2);

    }
}
