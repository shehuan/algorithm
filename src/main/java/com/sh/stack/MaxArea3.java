package com.sh.stack;

import java.util.Stack;

/**
 * 直方图是由排列在同一基线上的相邻柱子组成的图形。输入一个由非负数组成的数组，数组中的数字是直方图宽为1的柱子的高。
 * 求直方图中最大矩形的面积。例如，输入数组[3, 2, 5, 4, 6, 1, 4, 2]，
 * 该直方图中最大的矩形的面积为12，如阴影部分所示。
 */
public class MaxArea3 {
    public int max(int[] heights) {
        int maxArea = 0;
        // 保存数组元素的下标
        // 遍历数组元素，如果当前元素大于栈顶下标对应的元素，则将当前元素下标入栈，否则将栈顶下标出栈，
        // 这样可以保证栈中下标对应的元素是递增排列的
        // 出栈时计算以栈顶对应元素高的面积，此时栈顶左侧对应元素小于栈顶的，右侧是当前元素也小于栈顶对应的元素
        // 面积=（当前元素下标-栈顶左侧下标）* 栈顶对应元素
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        // 数组遍历完后，栈中可能还有下标，对应的元素是递增的，逐个出栈，计算对应的面积
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {3, 2, 5, 4, 6, 1, 4, 2};
        int maxArea = new MaxArea3().max(heights);
        System.out.println(maxArea);
    }
}
