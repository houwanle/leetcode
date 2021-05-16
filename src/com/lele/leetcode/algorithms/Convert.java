package com.lele.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lele
 * @date: 2021/5/16 17:40
 * @description: Z字形变换
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 */

public class Convert {
    public static void main(String[] args) {
        Convert convert = new Convert();

        String str = "LEETCOD";

        System.out.println(convert.convert(str, 3));
    }

    /**
     * Z字形变换
     * @param str 需要变换的字符串
     * @param numRows 行数
     * @return 变换后的字符串
     */
    public String convert(String str, int numRows) {
        if (numRows < 2) {
            return str;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : str.toCharArray()) {
            // 将字符串填入对应的行
            rows.get(i).append(c);
            // 在Z字形转折点的时候，执行反向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            // 更新当前字符串对应的行索引
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder r : rows) {
            res.append(r);
        }

        return res.toString();
    }
}
