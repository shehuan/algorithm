package com.sh.hash;

/**
 * 有一门外星语言，它的字母表刚好包含所有的英文小写字母，只是字母表的顺序不同。
 * 给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序。
 * 例如，输入一组单词["offer", "is", "coming"]，以及字母表顺序"zyxwvutsrqponmlkjihgfedcba"，
 * 由于字母'o'在字母表中位于'i'的前面，所以单词"offer"排在"is"的前面；
 * 同样由于字母'i'在字母表中位于'c'的前面，所以单词"is"排在"coming"的前面。
 * 因此这一组单词是按照字母表顺序排序的，应该输出true。（值比较每个单第一个不相同的字母）
 */
public class AlienSort {
    public boolean isAlienSort(String[] words, String order) {
        // 将字母顺序表中每个字母转成数组的下标，此下标对应的值为当前索引，也可以直接用map实现
        int[] orders = new int[order.length()];
        for (int i = 0; i < orders.length; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        // 逐个比较相邻的单词的顺序
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                int c1 = word1.charAt(j) - 'a';
                int c2 = word2.charAt(j) - 'a';
                if (orders[c1] > orders[c2]) {
                    return false;
                }
                if (orders[c1] < orders[c2]) {
                    return true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new AlienSort().isAlienSort(new String[]{"offer", "is", "coming"}, "zyxwvutsrqponmlkjihgfedcba");
        System.out.println(result);
    }
}
