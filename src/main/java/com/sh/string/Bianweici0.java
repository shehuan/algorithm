package com.sh.string;

/**
 * 输入两个字符串s1和s2，如何判断s2中是否包含s1的某个变位词？
 * 如果s2中包含s1的某个变位词，则s1至少有一个变位词是s2的子字符串。
 * 假设两个输入字符串中只包含英语小写字母。
 * 例如输入字符串s1为"ab"，s2为"dgcaf"，由于s2中包含s1的变位词"ba"，因此输出是true。
 * 如果输入字符串s1为"ac"，s2为"dcgaf"，输出为false。
 */
public class Bianweici0 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("") || s2.length() < s1.length()) {
            return false;
        }

        // 用数组保存每个字母出现的次数，将字母换算成索引
        int[] counts = new int[26];
        // 计算s1中每个字母出现的次数
        // 尝试s2中前s1.length()个字母是否包含s1的变位词
        // 可以理解为有两个指针，第一个指针指向子串的第一个字母，第二个指针指向子串的最后一个字母，子串长度就是s1的长度
        int i = 0;
        for (; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        // 如果s2中前s1.length()个字母包含s1的变位词，则counts中所有值都为0
        if (areAllZero(counts)) {
            return true;
        }

        // 此时的循环，i相当于每次指向s2中一个新的字母，即将两个指针向右同时移动一位
        for (; i < s2.length(); i++) {
            // 尝试用新字母消耗掉counts中s1中字母出现的次数
            counts[s2.charAt(i) - 'a']--;
            // 上一次两个指针之间指向的字母出现的次数都做了减1操作，但没有找到变位词，
            // 所以指针右移后需要将第一个指针的左边一位的字母出现次数加1，即恢复原来的字母次数
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (areAllZero(counts)) {
                return true;
            }
        }

        return false;
    }

    private boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Bianweici0().checkInclusion("cg", "dcgaf");
        System.out.println(result);
    }
}
