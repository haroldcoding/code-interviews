package code.interviews;

/**
 * @author haroldcoding
 * @create 2017/08/04/16:01
 */
public class Number33 {
    
    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        // 交换相邻两个数的位置，直到数组中 0 - i位组成的数最小
        // 遍历完成后整个数组组成的数就是最小的数
        for (int i = 1; i < numbers.length; i++) {
            for (int k = i; k != 0; k--) {
                String s1 = numbers[k - 1] + "" + numbers[k];
                String s2 = numbers[k] + "" + numbers[k - 1];
                if (s2.equals(minStringOfNum(s1, s2))) {
                    swap(numbers, k - 1, k);
                } else {
                    break;
                }
            }
            
        }
        StringBuilder res = new StringBuilder();
        for (int number : numbers) {
            res.append(number);
        }
        return res.toString();
    }
    
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static String minStringOfNum(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return b;
            } else if (a.charAt(i) < b.charAt(i)) {
                return a;
            }
        }
        return a;
    }
    
    
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4};
        System.out.println(printMinNumber(arr));
    }
}
