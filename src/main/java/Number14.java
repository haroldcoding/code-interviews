import java.util.LinkedList;
import java.util.Queue;

/**
 * 调整数组顺序使奇数位于偶数前面，
 *
 * @author haroldcoding
 * @create 2017/07/11/22:21
 */
public class Number14 {
    
    /**
     * 不必保持奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void reOrderArray1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if ((array[start] & 1) == 0) {
                while ((array[end] & 1) != 1 && start < end) {
                    --end;
                }
                int temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            } else {
                start++;
            }
        }
    }
    
    /**
     * 保持奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        Queue<Integer> evenNumbers = new LinkedList<>();
        Queue<Integer> oddNumbers = new LinkedList<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if ((array[i] & 1) == 0) {
                evenNumbers.offer(array[i]);
            } else if ((array[i] & 1) == 1) {
                oddNumbers.offer(array[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (!oddNumbers.isEmpty()) {
                array[i] = oddNumbers.poll();
            } else if (!evenNumbers.isEmpty()) {
                array[i] = evenNumbers.poll();
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reOrderArray(array);
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("================");
        int[] array1 = {2,1,2,4,6,8};
        reOrderArray1(array1);
        for (int i : array1) {
            System.out.println(i);
        }
        System.out.println("================");
        int[] array2 = {2,10,2,4,6,8};
        reOrderArray1(array2);
        for (int i : array2) {
            System.out.println(i);
        }
    }
}
