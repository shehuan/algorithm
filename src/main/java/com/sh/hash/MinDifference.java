package com.sh.hash;

/**
 * 给你一组范围在00:00至23:59的时间，求它们任意两个时间之间的最小时间差。
 * 例如，输入时间数组["23:50", "23:59", "00:00"]，"23:59"和"00:00"之间只有1分钟间隔，是最小的时间差。
 */
public class MinDifference {
    public int minDiff(String[] times) {
        if (times == null || times.length < 2) {
            return 0;
        }
        // 输入的时间是【小时:分钟】的结构，从00:00到23:59，即24小时有1440分钟，
        // 可以定义一个1440长的boolean数组，将时间换算成分钟，则分钟可以作为数组的索引，对应的值默认为false，
        // 然后每次将输入的时间在数组中对应的值改为true，此时输入的时间也就按照从小到大的顺序排列了。
        // 最后遍历这个数组，计算相邻值为true的索引插值，就是对应的时间差，
        // 由于输入的时间数组中，最小的时间可能是第二天的时间，比如["00:00", "23:50", "23:59"]、["23:50", "23:59", "00:00"]
        // 所以需要单独计算最小时间加24小时后和之前最大时间的差值
        boolean[] minutes = new boolean[1440];
        for (String time : times) {
            String[] split = time.split(":");
            int minute = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            minutes[minute] = true;
        }
        // 计算最小时间差
        // 上一个时间的索引
        int prev = -1;
        // 最小时间的索引
        int min = minutes.length;
        // 最大时间的索引
        int max = -1;
        // 最小时间差
        int minDiff = minutes.length;
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i]) {
                if (prev != -1) {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
        }
        //计算计算输入的最小时间和最大时间的差值
        minDiff = Math.min(min + 1440 - max, minDiff);
        return minDiff;
    }

    public static void main(String[] args) {
        String[] times = {"23:50", "23:59", "00:00"};
        int minDiff = new MinDifference().minDiff(times);
        System.out.println(minDiff);
    }
}
