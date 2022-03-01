package com.sh.stack;

import java.util.Stack;

/**
 * 输入一个表示小行星的数组，数组中每个数字的绝对值表示小行星的大小，
 * 数字的正负号表示小行星运动的方向，正号表示向右飞行，负号表示向左飞行。
 * 如果两个小行星相撞，体积较小的小行星将会爆炸最终消失，体积较大的小行星不受影响。
 * 如果相撞的两个小行星大小相同，它们都会爆炸。飞行方向相同的小行星永远不会相撞。求最终剩下的小行星。
 * 例如，假如有六个小行星[4, 5, -6, 4, 8, -5]（如图6.2所示），它们相撞之后最终剩下三个小行星[-6, 4, 8]。
 */
public class AsteroidCollision {
    public int[] collision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() <= -asteroid) {
                // 栈顶为向右飞行的，当前为向左飞行的，并且体积大于等于栈顶的，则将栈顶的出栈
                stack.pop();
            }
            if (asteroid > 0 || stack.empty() || stack.peek() < 0) {
                // 向右飞行、栈为空、栈顶元素小于0的情况，直接入栈
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] asteroids = {4, 5, -6, 4, 8, -5};
        asteroids = new AsteroidCollision().collision(asteroids);
        for (int asteroid : asteroids) {
            System.out.print(asteroid + " ");
        }
    }
}
