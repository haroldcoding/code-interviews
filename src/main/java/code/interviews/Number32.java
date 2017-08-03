package code.interviews;


/**
 * @author haroldcoding
 * @create 2017/08/02/16:52
 */
public class Number32 {
    
    /**
     * 不考虑时间复杂度的解法
     */
    public static int solution2(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numberOfOne(i);
        }
        return result;
    }
    
    /**
     * 判断一个整数含有多少个1
     *
     * @param n 待判断的整数
     * @return 含有1的个数
     */
    private static int numberOfOne(int n) {
        int num = 0;
        while (n != 0) {
            num += n % 10 == 1 ? 1 : 0;
            n /= 10;
        }
        return num;
    }
    
    public static int numberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        
        int len = getLenOfNum(n);
        if (len == 1) {
            return 1;
        }
        int temp = powBase10(len - 1);
        //假设 n = 21345, 取最高位
        int top = n / temp;
        // 1345
        int numExcludeTop = n % temp;
        //最高位为 1 时的个数即10000 - 19999
        int firstOneNum = top == 1 ? numExcludeTop + 1 : temp;
        // 最高位除了第一位为 1 之外的个数 1346 - 21345
        int otherOneNum = top * (len - 1) * (temp / 10);
        // 除去最高位，1 - splitTop 之间 1的个数
        return firstOneNum + otherOneNum + numberOf1Between1AndN_Solution(numExcludeTop);
    }
    
    /**
     * 获得 num 的位数
     *
     * @param num 待求位数的数
     * @return num 位数
     */
    private static int getLenOfNum(int num) {
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }
    
    /**
     * 10 的 base 次幂
     *
     * @param base 幂次
     * @return 10 的 base 次幂
     */
    private static int powBase10(int base) {
        return (int) Math.pow(10, base);
    }
    
    /**
     * 从个位到最高位依次计算 1  出现的次数，所得次数累加和就是所求：
     * 比如 一个 n 位的整数， 第 i 位 固定为1 的次数分三种情况：
     * 如果第 i 位数为 m  :
     * 当 m > 1 ，则 第i 位左边看成一个数的话，取值范围在 0 到  high = n / Math.pow(10,i), 而从第1位到第i-1位
     * 每一位取值都可以从0-9中取，所以 总数为 (high+1)*Math.pow(10,i-1);
     * 当 m = 1 ，则第 i 位 左边的数取值范围在 0 到 high，但是当取到high时，从第1位到第i-1位每一位就不是从0-9取了，
     * 比如2193，当百位即第3位固定为1的时候，左边取2时，就要计算2100 - 2193范围内含有1的整数的个数，即 93 + 1 个
     * 所以此时总数为 high*Math.pow(10,i-1) + n % Math.pow(10,i) % Math.pow(10,i-1) + 1;
     * 当 m < 1 ，则第 i 位 左边的数取值范围在 0 到 high-1，从第1位到第i-1位依然每一位取值都可以从0-9中取,
     * 总数为 high*Math.pow(10,i-1)
     */
    public static int solution3(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 0;
        for (int k = 10, high = n, low = 0; high != 0; k *= 10) {
            // 第 i 位的高位,
            high = n / k;
            result += high * (k / 10);
            int temp = n % k;
            // 第 i 位 的数字
            int cur = temp / (k / 10);
            // 第 i 位 的低位
            low = temp % (k / 10);
            //
            if (cur > 1) {
                result += k / 10;
            } else if (cur == 1) {
                result += low + 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        int test = 1513;
        boolean hasErr = numberOf1Between1AndN_Solution(test) != solution3(test);
        if (hasErr) {
            System.out.println("233333333333");
        } else {
            System.out.println("666666666666");
        }
    }
}
