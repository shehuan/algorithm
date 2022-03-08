package com.sh.stack;

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
