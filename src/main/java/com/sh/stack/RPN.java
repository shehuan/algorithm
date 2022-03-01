package com.sh.stack;

import java.util.Stack;

/**
 * 后缀表达式是一种算术表达式，它的操作符在操作数的后面。
 * 输入一个用字符串数组表示的后缀表达式，请输出该后缀表达式的计算结果。假设输入的一定是有效的后缀表达式。
 * 例如，后缀表达式["2", "1", "3", "*", "+"]对应的算术表达式是“2 + 1 * 3”，因此输出它的计算结果5。
 */
public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(cal(num1, num2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int cal(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "3", "*", "+"};
        int i = new RPN().evalRPN(tokens);
        System.out.println(i);
    }
}
