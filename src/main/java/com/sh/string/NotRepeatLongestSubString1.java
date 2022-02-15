package com.sh.string;

/**
 * 输入一个字符串，求该字符串中不含重复字符的最长连续子字符串的长度。
 * 例如，输入字符串"babcca"，它最长的不含重复字符串的子字符串是"abc"，长度为3。
 */
public class NotRepeatLongestSubString1 {
    public int lengthOfLongestSubString(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        // 假设字符串只包含256个ASCII码
        int[] counts = new int[256];
        // 记录最大长度
        int longest = 0;
        // 标记出现了重复字符
        boolean repeat = false;
        // 第一个指针，指向子串的第一个字符
        int j = 0;
        // 第二个指针，指向子串的最后一个字符
        int i = 0;
        // 初始时两个指针分别指向第一个字符，当子串不包含重复字符时，向右移动第二个指针给子串添加新的字符，
        // 当向右移动第二个指针子串出现重复字符时，说明前边已经找到一个最长的不含重复子串，
        // 开始向右移动第一个指针，从子串中删除字符，直到子串不包含重复字符后，再开始向右移动第二个指针
        for (; i < s.length(); i++) {
            // 记录当前字符出现的次数，即子串不包含重复字符时，每次向右移动第二个指针i，添加新的字符
            counts[s.charAt(i)]++;
            // 当某个字符出现次数大于1（也就是第二次出现），该子串有了重复字符，
            if (counts[s.charAt(i)] == 2) {
                repeat = true;
            }
            // 需要开始向右移动第一个指针j，
            // 即循环删除最左边的一个字符，直到子串不包含重复字符
            while (repeat) {
                counts[s.charAt(j)]--;
                // 已经删掉了重复字符
                if (counts[s.charAt(j)] == 1) {
                    repeat = false;
                }
                j++;
            }
            longest = Math.max(longest, i - j + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        int result = new NotRepeatLongestSubString1().lengthOfLongestSubString("babcdefnca");
        System.out.println(result);
    }
}
