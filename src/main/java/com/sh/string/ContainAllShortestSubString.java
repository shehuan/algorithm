package com.sh.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入两个字符串s和t，请找出s中包含t的所有字符的最短子字符串。
 * 例如输入s为字符串"ADDBANCAD"，t为字符串"ABC"，则s中包含字符'A'、'B'、'C'的最短子字符串是"BANC"。
 * 如果不存在符合条件的子字符串，返回空字符串""。如果存在多个符合条件的子字符串，返回任意一个。
 */
public class ContainAllShortestSubString {
    public String minWindow(String s, String t) {
        if (s == null || s.equals("") || t == null || t.equals("") || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> charToCount = new HashMap<>();
        // 计算t中每个字符出现的次数
        for (char c : t.toCharArray()) {
            charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
        }
        // t中包含的字符种类数
        int count = charToCount.size();
        // 子串的最小长度
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        while (end < s.length() || (count == 0 && end == s.length())) {
            if (count > 0) {
                // 第二个指针右移，即向子串右边添加新的字符
                char endCh = s.charAt(end);
                if (charToCount.containsKey(endCh)) {
                    // 新字符是否在t中存在，则将t中对应字符数量减一
                    charToCount.put(endCh, charToCount.get(endCh) - 1);
                    if (charToCount.get(endCh) == 0) {
                        count--;
                    }
                }
                end++;
            } else {
                if (end - start < minLength) { // 找到了s中包含t的所有字符的最短子字符串
                    minLength = end - start;
                    // 记录最短子串的开始、结束索引
                    minStart = start;
                    minEnd = end;
                } else {
                    // 第一个指针右移，即从子串左边删除字符
                    char startCh = s.charAt(start);
                    if (charToCount.containsKey(startCh)) {
                        // 第二个指针右移时做了减一操作，第一个指针右移时需要恢复t中对应字符数量（加一）
                        charToCount.put(startCh, charToCount.get(startCh) + 1);
                        if (charToCount.get(startCh) == 1) {
                            count++;
                        }
                    }
                    start++;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);
    }

    public static void main(String[] args) {
        String result = new ContainAllShortestSubString().minWindow("ADDBANCABCD", "ABC");
        System.out.println(result);
    }
}
