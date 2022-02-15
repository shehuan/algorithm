package com.sh.string;

/**
 * 给定一个字符串，请判断如果最多从字符串中删除一个字符能不能得到一个回文字符串。
 * 例如，如果输入字符串"abca"，由于删除字符'b'或者'c'就能得到一个回文字符串，因此输出为true。
 */
public class Palindrome1 {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        for (; i < s.length() / 2; i++, j--) {
            // 发现不相同的字符
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return i == s.length() / 2
                || isPalindrome(s, i + 1, j)
                || isPalindrome(s, i, j - 1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Palindrome1().validPalindrome("aaabcba");
        System.out.println(result);
    }
}
