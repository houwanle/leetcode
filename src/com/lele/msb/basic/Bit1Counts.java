package com.lele.msb.basic;

/**
 * @author: lele
 * @date: 2023/4/7 07:59
 * @description: 统计一个十进制数中二进制1的个数
 */

public class Bit1Counts {

    public static void main(String[] args) {
        System.out.println(bit1count(15));
    }

    public static int bit1count(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & ((~N) + 1); // 提取最右侧的1
            count++;
            N ^= rightOne; //抹掉最右侧的1
        }

        return count;
    }
}
