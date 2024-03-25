package com.lele.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: lele
 * @date: 2024/3/25 19:02
 * @description: 字母异位词分组
 * 描述：给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *      字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 思路：字母相同，但排列不同的字符串，排序后都一定是相同的。
 *
 *
 */

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams1(strs));
    }

    /**
     * 注意 groupingBy 算子计算完以后，返回的是一个 Map<String, List<String>>，
     * map 的键是每种排序后的字符串，值是聚合的原始字符串，我们只关心值，
     * 所以我们最后 new ArrayList<>(map.values())。
     *
     * @param strs
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            // 返回str排序后的结果
            // 按排序后的结果来 group by，算子 类似于 sql 里的 group by。
            char[] array = str.toCharArray();
            Arrays.sort(array);
            return new String(array);
        })).values());
    }

    private static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
