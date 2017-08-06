package code.interviews;

import java.util.Random;

/**
 * 丑数
 *
 * @author haroldcoding
 * @create 2017/08/04/21:48
 */
public class Number34 {
    
    public static int solution1(int index) {
        if (index <= 0) {
            return 0;
        }
        int result = 0;
        int found = 0;
        while (found < index) {
            ++result;
            if (isUglyNumber(result)) {
                ++found;
            }
        }
        return result;
    }
    
    public static boolean isUglyNumber(int number) {
        if (number == 1) {
            return true;
        }
        while (number % 2 == 0) {
            number >>= 1;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }
    
    public static int solution2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyIndex = 1;
        int p2Index = 0;
        int p3Index = 0;
        int p5Index = 0;
        while (nextUglyIndex < index) {
            int p2 = uglyNums[p2Index] * 2;
            int p3 = uglyNums[p3Index] * 3;
            int p5 = uglyNums[p5Index] * 5;
            uglyNums[nextUglyIndex] = getMinOfThree(p2, p3, p5);
            while (p2 <= uglyNums[nextUglyIndex]) {
                ++p2Index;
                p2 = uglyNums[p2Index] * 2;
            }
            while (p3 <= uglyNums[nextUglyIndex]) {
                ++p3Index;
                p3 = uglyNums[p3Index] * 3;
            }
            while (p5 <= uglyNums[nextUglyIndex]) {
                ++p5Index;
                p5 = uglyNums[p5Index] * 5;
            }
            ++nextUglyIndex;
        }
        return uglyNums[index - 1];
    }
    
    private static int getMinOfThree(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
    
    public static void main(String[] args) {
        boolean hasErr = false;
        int test = 100;
        for (int i = 0; i < test; i++) {
            int index = (int) (Math.random() * 10);
            if(solution1(index) != solution2(index)){
                hasErr = true;
                break;
            }
        }
        if(hasErr){
            System.out.println("2333");
        } else {
            System.out.println("666666");
        }
    }
}
