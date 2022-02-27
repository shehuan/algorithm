package com.sh.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t，请判断它们是不是一组变位词。
 * 在一组变位词中，如果它们中的字符以及每个字符出现的次数都相同，但字符的顺序不能。例如"anagram"和"nagaram"就是一组变位词。
 */
public class Anagram {
    /**
     * 假设只包含26个小写字母
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char c : str1.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a']--;
        }
        return true;
    }

    /**
     * Unicode编码的所有字符
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram2(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str1.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }
            counts.put(c, counts.getOrDefault(c, 0) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        boolean result = anagram.isAnagram("aaabbcc", "aabbccc");
        System.out.println(result);
    }
}
