import java.math.BigInteger;

/**
 * 打印从1 到最大的 n 位十进制数
 *
 * @author haroldcoding
 * @create 2017/07/11/11:35
 */
public class Number12 {
    
    /**
     * 利用 Java 提供的大数类 BigInteger 实现
     */
    public static void print_1_ToMaxOfNDigits(int n) {
        if (n < 1) {
            throw new RuntimeException("参数必须大于0");
        }
        BigInteger max = BigInteger.valueOf(1);
        for (int i = 0; i < n; i++) {
            max = max.multiply(BigInteger.TEN);
        }
        BigInteger result = BigInteger.ONE;
        while (result.compareTo(max) < 0) {
            System.out.println(result);
            result = result.add(BigInteger.ONE);
        }
    }
    
    /**
     * 递归实现
     */
    public static void print_1_ToMaxOfNDigits1(int n) {
        int[] result = new int[n];
        for (int i = 0; i < 10; i++) {
            result[0] = i;
            print_1_ToMaxOfNDigits1(result, 0);
        }
    }
    
    private static void print_1_ToMaxOfNDigits1(int[] number, int index) {
        if (index == number.length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = i;
            print_1_ToMaxOfNDigits1(number, index + 1);
        }
    }
    
    private static void printNumber(int[] number) {
        boolean isBeginWithZero = true;
        boolean fullOfZero = true;
        for (int i = 0, length = number.length; i < length; i++) {
            if (isBeginWithZero && number[i] != 0) {
                isBeginWithZero = false;
                fullOfZero = false;
            }
            if (!isBeginWithZero) {
                System.out.print(number[i]);
            }
        }
        if (!fullOfZero) {
            System.out.println();
        }
        
    }
    
    /**
     * 用长度为 n 的数组模拟 n 位数，然后模拟整数加1的操作，当最高位溢出，即数组第一个元素大于等于10的时候停止输出。
     * 每次输出时从数组的第一个不为 0 的数开始输出，输出完成后换行。
     * @param n
     */
    public static void printOneToMax_N_Digits(int n) {
        int[] result = new int[n];
        while (!addOne(result)) {
            printNumber(result);
        }
    }
    
    private static boolean addOne(int[] number) {
        boolean isMaxOverflow = false;
        int lastIndex = number.length - 1;
        int index = lastIndex;
        number[lastIndex] += 1;
        for (int i = lastIndex; i > 0; i--) {
            if (number[i] >= 10) {
                number[i] = 0;
                number[i - 1] += 1;
            }
            if (i - 1 == 0 && number[i - 1] >= 10) {
                isMaxOverflow = true;
                break;
            }
        }
        return isMaxOverflow;
    }
    
    public static void main(String[] args) {
        //print_1_ToMaxOfNDigits1(2);
        printOneToMax_N_Digits(2);
    }
}
