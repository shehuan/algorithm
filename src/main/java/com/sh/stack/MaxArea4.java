package com.sh.stack;

public class MaxArea4 {
    public int max(int[][] array) {
        MaxArea3 maxArea3 = new MaxArea3();
        int maxArea = 0;
        // 保存以二维数组每一行为基准的柱子的高
        int[] heights = new int[array[0].length];
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    heights[i] = 0;
                } else {
                    heights[i] += 1;
                }
            }
            maxArea = Math.max(maxArea3.max(heights), maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] array = new int[4][6];
        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 0;
        array[0][3] = 1;
        array[0][4] = 0;
        array[0][5] = 1;
        array[1][0] = 1;
        array[1][1] = 1;
        array[1][2] = 1;
        array[1][3] = 1;
        array[1][4] = 1;
        array[1][5] = 1;
        array[2][0] = 0;
        array[2][1] = 1;
        array[2][2] = 1;
        array[2][3] = 1;
        array[2][4] = 1;
        array[2][5] = 1;
        array[3][0] = 1;
        array[3][1] = 0;
        array[3][2] = 0;
        array[3][3] = 1;
        array[3][4] = 1;
        array[3][5] = 1;
        MaxArea4 maxArea4 = new MaxArea4();
        int max = maxArea4.max(array);
        System.out.println(max);
    }
}
