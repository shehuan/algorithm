package com.sh.stack;

/**
 * 直方图是由排列在同一基线上的相邻柱子组成的图形。输入一个由非负数组成的数组，数组中的数字是直方图宽为1的柱子的高。
 * 求直方图中最大矩形的面积。例如，输入数组[3, 2, 5, 4, 6, 1, 4, 2]，
 * 该直方图中最大的矩形的面积为12，如阴影部分所示。
 */
public class MaxArea1 {
    public int max(int[] heights) {
        int maxArea = 0;
        int minHeight;
        for (int i = 0; i < heights.length; i++) {
            minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                // 计算当前最小高度
                minHeight = Math.min(minHeight, heights[j]);
                // 计算当前最大面积
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {3, 2, 4, 1, 3};
        int maxArea = new MaxArea1().max(heights);
        System.out.println(maxArea);
    }
}
