package com.lele.msb.novice;

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

        System.out.println("============从1~5随机到1~7随机===========");


        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            counts[num]++;
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }

        System.out.println("===========从01不等概率随机到01等概率随机============");

        int[] counts1 = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int num = y();
            counts1[num]++;
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(i + "这个数，出现了 " + counts1[i] + " 次");
        }
    }

    /**
     * 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到！
     * @return
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 等概率返回0和1
     * @return
     */
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

    /**
     * 产生1~5的随机整数
     * @return
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 在f1()的基础上产生等概率的0，1整数
     * @return
     */
    public static int f2() {

        int ans;
        do
        {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 得到000 ~ 111 做到等概率 0 ~ 7等概率返回一个
     * @return
     */
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    /**
     * 0 ~ 6 的整数等概率返回
     * @return
     */
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    /**
     * 得到 1 ~ 7 等概率返回
     * @return
     */
    public static int g() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 0);
        return ans;
    }

//    Math.random(); 返回[0,1)之间的一个小数

    private static double xToPower2() {
        return Math.max(Math.random(), Math.random()); // 可求出现在[0,X^2）上的概率
    }


}
