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
    
    public static void main(String[] args) {
        
        int test = 1513;
        boolean hasErr = numberOf1Between1AndN_Solution(test) != solution2(test);
        if (hasErr) {
            System.out.println("233333333333");
        } else {
            System.out.println("666666666666");
        }
    }
}
