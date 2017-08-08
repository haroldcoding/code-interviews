package code.interviews;


import java.util.HashMap;

/**
 * 数组中只出现一次的数字 一个整型数组里除了两个数字之外，其他的数字出现了两次，找到这两个数字，要求时间复杂度O(n),空间复杂度O（1）
 *
 * @author haroldcoding
 * @create 2017/08/06/20:46
 */
public class Number40 {
    
    /**
     * 利用位运算 异或
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
        num >>= (n - 1);
        return (num & 1) == 1;
    }
    
    private static int getIndexOfFirstBitIsOne(int num) {
        // return num &~(num-1); 也可以求最低位1的位置
        int res = 0;
        while (num != 0) {
            ++res;
            num >>= 1;
        }
        return res;
    }
    
    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     *
     * @param arr 数组
     * @return 只出现一次的数
     */
    public static int solution3(int[] arr) {
        if (arr == null || arr.length < 4) {
            throw new IllegalArgumentException("数组长度必须大于或等于4");
        }
        // 用一个32位的数组保存数组arr中所有数的二进制对应位的和
        int[] bits = new int[32];
        for (int i = 0, len = arr.length; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((arr[i] >> j) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }
    
    /**
     * 一个数组中只有三个数只出现一次，其余都出现两次，找到这三个数
     *
     * @param arr 数组
     * @param res 长度为3的数组，保存三个只出现一次的数
     */
    public static void solution4(int[] arr, int[] res) {
        if (arr.length < 3) {
            return;
        }
        int xExclusiveOr = 0;
        // 假设三个数为 a b c
        // 循环完成后结果为 x = a^b^c
        for (int i : arr) {
            xExclusiveOr ^= i;
        }
        int flag = 0;
        // 设f(n)为求非零正数n 的二进制数从右往左第一个1的位置
        // 循环完成后 结果为 f(x^a) ^ f(x^b) ^ f(x^c)
        for (int i : arr) {
            flag ^= lastOfBitOne(xExclusiveOr ^ i);
        }
        // 上一步循环后，再求结果的 二进制数从右往左第一个1的位置，假设为m
        // 此时  x^a x^b  x^c 三个数只有一个第m位为1，假定为x^a
        flag = lastOfBitOne(flag);
        int firstUniqueNumIndex = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // 由于其他数与a都不相等， 所以f(x^other) 也不等于 flag
            // 所以在遍历一遍数组，分别求f(x^i) 当等于flag时的那个数就是第一个只重复一次的数，结束循环
            if (lastOfBitOne(xExclusiveOr ^ arr[i]) == flag) {
                res[0] = arr[i];
                firstUniqueNumIndex = i;
                break;
            }
        }
        // 将找到的这个数放到数组末尾
        swap(arr, firstUniqueNumIndex, len - 1);
        // 在数组 0 - len-2 内找剩余的两个数
        int[] twoUnique = getTwoUnique(arr, 0, len - 2);
        res[1] = twoUnique[0];
        res[2] = twoUnique[1];
    }
    
    private static int[] getTwoUnique(int[] arr, int start, int end) {
        int[] res = new int[2];
        int xExclusiveOr = 0;
        for (int i = start; i <= end; i++) {
            xExclusiveOr ^= arr[i];
        }
        int lastOfBitOneIndex = lastOfBitOne(xExclusiveOr);
        for (int i = start; i <= end; i++) {
            if (lastOfBitOne(arr[i]) == lastOfBitOneIndex) {
                res[0] ^= arr[i];
            } else {
                res[0] ^= arr[i];
            }
        }
        return res;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int lastOfBitOne(int num) {
        return num & ~(num - 1);
    }
    
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length != numbers.length) {
            return false;
        }
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i : numbers) {
            if (i > length - 1 || i < 0) {
                return false;
            }
            if (numMap.containsKey(i)) {
                numMap.put(i, numMap.get(i) + 1);
            } else {
                numMap.put(i, 1);
            }
        }
        for (int i : numbers) {
            if (numMap.get(i) > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }
    
    public static boolean duplicate2(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length != numbers.length) {
            return false;
        }
        for (int index = 0; index < length; index++) {
            if (numbers[index] > length) {
                duplication[0] = numbers[index] - length;
                return true;
            } else {
                numbers[numbers[index]] += length;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution(array, num1, num2);
        int[] a = {1, 3, 3, 3};
        System.out.println(duplicate(a, 4, new int[1]));
    }
}
