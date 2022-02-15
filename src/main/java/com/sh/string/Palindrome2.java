package com.sh.string;

/**
 * 给定一个字符串，请问字符串里有多少回文连续子字符串？
 * 例如，字符串里"abc"有3个回文字符串，分别为"a"、"b"、"c"；
 * 而字符串"aaa"里有6个回文子字符串，分别为"a"、"a"、"a"、"aa"、"aa"和"aaa"。
 */
public class Palindrome2 {
    public int countSubstrings(String s) {
        int count = 0;
        if (s == null || s.length() == 0) {
            return count;
        }
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            System.out.println(s.substring(i, j + 1));
            i--;
            j++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int result = new Palindrome2().countSubstrings("aaaabcba");
        System.out.println(result);
    }
}
