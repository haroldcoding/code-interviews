package code.interviews;

import java.util.Arrays;

/**
 * @author haroldcoding
 * @create 2017/08/08/16:47
 */
public class Number44 {
    
    public static boolean solution(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        int countOfZero = 0;
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i] == 0) {
                countOfZero++;
            } else {
                int c = numbers[i + 1] - numbers[i] - 1;
                if (c < 0 || c > countOfZero) {
                    return false;
                } else {
                    countOfZero -= c;
                }
            }
        }
        return countOfZero == len || countOfZero >= 0;
    }
    
    public static void main(String[] args) {
        int[] a = {0, 3, 6, 1, 4};
        int[] b = {0, 2, 4, 5, 6};
        int[] c = {1, 2, 3, 4, 5};
        int[] d = {1, 5, 8, 9, 3};
        System.out.println(solution(a));
    }
}
