package code.interviews;

/**
 * 连续子数组的最大和
 *
 * @author haroldcoding
 * @create 2017/08/02/16:17
 */
public class Number31 {
    
    public static int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0, size = arr.length; i < size; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSubArraySum(arr));
    }
}
