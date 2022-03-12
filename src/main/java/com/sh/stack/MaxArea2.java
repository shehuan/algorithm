package com.sh.stack;

/**
 * 直方图是由排列在同一基线上的相邻柱子组成的图形。输入一个由非负数组成的数组，数组中的数字是直方图宽为1的柱子的高。
 * 求直方图中最大矩形的面积。例如，输入数组[3, 2, 5, 4, 6, 1, 4, 2]，
 * 该直方图中最大的矩形的面积为12，如阴影部分所示。
 */
public class MaxArea2 {
    public int max(int[] heights) {
        return calArea(0, heights.length - 1, heights);
    }

    public int calArea(int start, int end, int[] heights) {
        if (start == end) {
            return heights[start];
        }
        int area;
        int minIndex = start;
        // 找到当前区间最小高度
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        // 计算当前区间最小高度对应的面积
        area = (end - start + 1) * heights[minIndex];
        // 递归计算当前高度左右两边区间的面积
        int left = calArea(start, minIndex - 1, heights);
        area = Math.max(area, left);
        int right = calArea(minIndex + 1, end, heights);
        area = Math.max(area, right);
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {3, 2, 4, 1, 3};
        int maxArea = new MaxArea2().max(heights);
        System.out.println(maxArea);
    }
}
