package com.sh.hash;

import java.util.*;

/**
 * 给定一组单词，请将它们按照变位词分组。
 * 例如输入一组单词["eat", "tea", "tan", "ate", "nat", "bat"]，则可以分成三组，
 * 分别是["eat", "tea", "ate"]、["tan", "nat"]和["bat"]。假设单词中只包含小写的英文字母。
 */
public class GroupAnagram {
    public List<List<String>> group(String[] strs) {
        // 将每个单词按照字母顺序重新排序，组为map的key，并把原值用集合存储起来
        // 这样相同变为词的会被分成一组
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.putIfAbsent(key, new LinkedList<>());
            groups.get(key).add(str);
        }
        return new LinkedList<>(groups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> group = new GroupAnagram().group(strs);
        group.forEach(g -> {
            g.forEach(s -> {
                System.out.print(s);
                System.out.print(" ");
            });
            System.out.println("\n");
        });
    }
}
