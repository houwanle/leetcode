package com.lele.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: lele
 * @date: 2023/6/4 14:02
 * @description: 明明的随机数
 * 描述：明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * 数据范围：1 <= n <= 1000,输入的数字大小满足 1 <= val <= 500
 * 示例：
 *  输入：3
 *       2
 *       2
 *       1
 *  输出：1
 *       2
 */

public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet treeSet = new TreeSet();

        for (int i = 0; i < n; i++){
            treeSet.add(sc.nextInt());
        }

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
