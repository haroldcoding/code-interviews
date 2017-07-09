import java.util.ArrayList;

/**
 * 斐波那契数列，求斐波那契数列第 n 项,n<=39
 *
 * @author haroldcoding
 * @create 2017/07/09/17:17
 */
public class Number9 {
    
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prePrevious = 0;
        int previous = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = prePrevious + previous;
            prePrevious = previous;
            previous = result;
        }
        return result;
    }
    
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 思路：
     * 由于青蛙可以跳上n级台阶，所以当该青蛙跳上一个 n 级台阶时可以从 n-1 级 到 1级任意一级台阶往上跳，也可以直接跳上
     * n 级台阶，所以 f(n) = f(n-1) + f(n-2) + ... + f(1) + 1.
     */
    public int JumpFloorII(int target) {
        int[] pre = {0, 1, 2};
        if (target <= 2) {
            return pre[target];
        }
        int[] result = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            if (i <= 2) {
                result[i] = i;
            } else {
                for (int j = 0; j < i; j++) {
                    result[i] += result[j];
                }
                ++result[i];
            }
            
        }
        return result[target];
    }
}
