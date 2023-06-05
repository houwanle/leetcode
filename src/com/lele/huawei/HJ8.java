package com.lele.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/5 14:10
 * @description: 合并表记录
 * 描述：数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * 提示：
 *  0 <= index <= 11111111
 *  1 <= value <= 100000
 * 示例
 *  输入：3
 *       0  1
 *       0  2
 *       8  9
 * 输出： 0  3
 *       8  9
 */

public class HJ8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tableSize = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>(tableSize);

        for (int i = 0; i < tableSize; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            if (map.containsKey(index)) {
                map.put(index, map.get(index) + value);
            } else {
                map.put(index, value);
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
