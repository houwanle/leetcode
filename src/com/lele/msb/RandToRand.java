package com.lele.msb;

/**
 * @author: lele
 * @date: 2022/8/1 上午7:53
 * @description: 随机数
 */

public class RandToRand {

    public static void main(String[] args) {

        double x = 0.3;
        int testTimes = 10000000;
        int count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (xToPower2() < x) {
                count++;
            }
        }

        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.max(Math.random(), Math.random()));
    }

//    Math.random(); 返回[0,1)之间的一个小数

    private static double xToPower2() {
        return Math.max(Math.random(), Math.random()); // 可求出现在[0,X^2）上的概率
    }
}
