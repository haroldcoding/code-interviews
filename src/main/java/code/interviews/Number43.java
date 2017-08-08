package code.interviews;

import java.util.Arrays;

/**
 * @author haroldcoding
 * @create 2017/08/07/15:32
 */
public class Number43 {
    
    public static int[] solution(int n) {
        if (n < 1) {
            return new int[]{0};
        }
        int[] pointSum = new int[6 * n - n + 1];
        int total = (int) Math.pow(6, n);
        for (int i = 1; i <= 6; i++) {
            getPossibility(pointSum, n, n - 1, i);
        }
        for (int i = 0; i < pointSum.length; i++) {
            pointSum[i] /= total;
        }
        return pointSum;
    }
    
    /**
     * 求每个点数和对应的骰子组合的可能性个数，由于骰子的点数和从 n - 6n 所以创建一个6n-n+1长度的数组。 所以所有骰子点数和为sum时的可能性有m种，那么 m 存在 sum - n
     * 的位置上
     *
     * @param pointSum 保存点数和
     * @param offset 骰子个数
     * @param current 当前剩余的骰子个数
     * @param sum 之前骰子的点数和
     */
    private static void getPossibility(int[] pointSum, int offset, int current, int sum) {
        if (current == 1) {
            pointSum[sum - offset]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            getPossibility(pointSum, offset, current - 1, sum += i);
        }
    }
    
    /**
     * 如果已经直到了 n-1 个骰子所有点数和对应的骰子排列的可能性，那么对于 n 个骰子来说，点数和为 m 时 对应于 n-1 个骰子时点数和为 m-1 ~ m-6 时的排列可能性的总和
     */
    public static int[] solution2(int n) {
        if (n < 1) {
            return new int[]{0};
        }
        int[][] dp = new int[2][6 * n + 1];
        int maxValue = 6;
        int flag = 0;
        for (int i = 1; i <= maxValue; i++) {
            dp[flag][i] = 1;
        }
        // 每次循环就相当于增加了一个骰子
        // 第 i 次循环， 当前骰子一共 i 个
        // 那么 骰子点数和范围为 i - 6i
        // 当计算这次循环时点数和为 i ~ 6i 中的每个值骰子点数的组合个数时
        // 比如点数和为  n 时， 那么增加的这个骰子点数可能为1~6，那么
        // 总个数就是 上次循环时 点数和 为 n-1 ~ n-6 的个数总和
        // 因为每次循环都要依赖上次循环的结果，所以用一个二位数组分别储存当前循环和上次循环的结果
        // 用一个变量 flag  标识上次循环，每次循环结束后更新 flag
        for (int i = 2; i <= n; i++) {
            for (int k = i; k <= maxValue * i; k++) {
                for (int j = 1; j < k && j <= maxValue; j++) {
                    dp[1 - flag][k] += dp[flag][k - j];
                }
            }
            flag = 1 - flag;
        }
        int total = (int) Math.pow(maxValue, n);
        for (int i = n; i <= n * maxValue; i++) {
            dp[flag][i] /= total;
        }
        return dp[flag];
    }
}
