package code.interviews;

/**
 * 数字在排序数组中出现的次数
 *
 * @author haroldcoding
 * @create 2017/08/06/16:39
 */
public class Number38 {
    
    /**
     * 利用二分查找确定该数第一次和最后一次在数组中出现的位置 topIndex 和 lastIndex，那么这个数出现的次数就是 lastIndex - topIndex + 1
     */
    public static int solution1(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = 0;
        int topIndex = getTopIndex(array, 0, array.length - 1, k);
        if (topIndex == -1) {
            return res;
        }
        int lastIndex = getLastIndex(array, 0, array.length - 1, k);
        
        return lastIndex - topIndex + 1;
    }
    
    private static int getTopIndex(int[] array, int start, int end, int k) {
        
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] > k) {
            return getTopIndex(array, start, mid, k);
        } else if (array[mid] < k) {
            return getTopIndex(array, mid + 1, end, k);
        } else {
            if (mid - 1 >= 0 && array[mid - 1] != k) {
                return mid;
            } else {
                return getTopIndex(array, start, mid - 1, k);
            }
        }
    }
    
    private static int getLastIndex(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] < k) {
            return getLastIndex(array, mid + 1, end, k);
        } else if (array[mid] > k) {
            return getTopIndex(array, start, mid - 1, k);
        } else {
            if ((mid + 1 < array.length && array[mid + 1] != k) || (mid + 1 == array.length)) {
                return mid;
            } else {
                return getLastIndex(array, mid + 1, end, k);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 3, 3, 3};
        System.out.println(getTopIndex(test, 0, test.length - 1, 3));
        System.out.println(getLastIndex(test, 0, test.length - 1, 3));
        System.out.println(solution1(test, 3));
        System.out.println(solution1(test, 1));
        System.out.println(solution1(test, 4));
    }
}
