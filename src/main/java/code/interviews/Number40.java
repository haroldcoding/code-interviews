package code.interviews;


/**
 * 数组中只出现一次的数字 一个整型数组里除了两个数字之外，其他的数字出现了两次，找到这两个数字，要求时间复杂度O(n),空间复杂度O（1）
 *
 * @author haroldcoding
 * @create 2017/08/06/20:46
 */
public class Number40 {
    
    /**
     * 利用位运算 异或
     * @param array
     * @param num1
     * @param num2
     */
    public static void solution(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int resExclusiveOr = 0;
        for (int i = 0; i < array.length; i++) {
            resExclusiveOr ^= array[i];
        }
        int indexOfFirstBitOne = getIndexOfFirstBitIsOne(resExclusiveOr);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isOneIndexOfNBit(array[i], indexOfFirstBitOne)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
    
    private static boolean isOneIndexOfNBit(int num, int n) {
        num >>= (n-1);
        return (num & 1) == 1;
    }
    
    private static int getIndexOfFirstBitIsOne(int num) {
        int res = 0;
        while (num != 0) {
            ++res;
            num >>= 1;
        }
        return res;
    }
    public static void main(String[] args){
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
