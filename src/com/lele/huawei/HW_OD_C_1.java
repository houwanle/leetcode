package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2024/3/23 11:09
 * @description:
 * 描述："吃货"和"馋嘴"两人到披萨店点了一份铁盘（圆形）披萨，并嘱咐店员将披萨按放射状切成大小相同的偶数扇形小块。
 *      但是粗心的服务员将披萨切成了每块大小都完全不同奇数块，且肉眼能分辨出大小。由于两人都想吃到最多的披萨，
 *      他们商量了一个他们认为公平的分法：从"吃货"开始，轮流取披萨。除了第一块披萨可以任意选取以外，其他必须都从缺口开始选。
 *      他两选披萨的思路不同。"馋嘴"每次都会选最大块的披萨，而且"吃货"知道"馋嘴"的想法。
 *      已知披萨小块的数量以及每块的大小，求"吃货"能分得的最大的披萨大小的总和。
 *
 * 输入描述：第1行为一个正整数奇数n，表示披萨小块数量。3 <= n <500
 *         接下来的第2行到第n+1行（共N行），每行为一个正整数，表示第i块披萨的大小。1<=i<=n。
 *         披萨小块从某一块开始，按照一个方向一次顺序编号为 1~N。每块披萨的大小范围为[1,2147483647]。
 * 输出描述："吃货"能分得的最大的披萨大小的总和。
 *
 * 输入：
 * 5
 * 8
 * 2
 * 10
 * 5
 * 7
 * 输出：
 * 19
 *
 *
 */

public class HW_OD_C_1 {

    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int scannerCount = Integer.parseInt(line);
        String nums[] = new String[scannerCount];

        for (int i = 0; i <scannerCount; i++) {
            String nextLine = scanner.nextLine();
            nums[i] = nextLine;
        }


        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        System.out.println(maxSizeSlices(arr));
    }

    public static int maxSizeSlices(int[] slices) {
        n = slices.length / 2;
        int[] nums = new int[slices.length - 1];
        System.arraycopy(slices, 1, nums, 0, nums.length);
        int a = func(nums);
        System.arraycopy(slices, 0, nums, 0, nums.length);

        int b = func(nums);
        return Math.max(a, b);
    }

    public static int func(int[] nums) {
        int m = nums.length;
        int[][] f = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j) {
                f[i][j] = Math.max(f[i-1][j], (i >= 2 ? f[i-2][j-1]:0) + nums[i - 1]);
            }
        }
        return f[m][n];
    }
}
