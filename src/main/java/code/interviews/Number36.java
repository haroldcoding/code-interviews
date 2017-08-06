package code.interviews;

/**
 * 数组中的逆序对
 *
 * @author haroldcoding
 * @create 2017/08/06/15:14
 */
public class Number36 {
    
    public static int solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] tempArr = new int[array.length];
        long res = mergeSort(array, 0, array.length - 1, tempArr);
        return (int) res;
    }
    
    private static long mergeSort(int[] arr, int start, int end, int[] tempArr) {
        if (start >= end) {
            return 0;
        }
        int mid = (end + start) / 2;
        long count1 = mergeSort(arr, start, mid, tempArr);
        long count2 = mergeSort(arr, mid + 1, end, tempArr);
        return count1 + count2 + merge(arr, start, end, tempArr);
    }
    
    private static long merge(int[] arr, int start, int end, int[] tempArr) {
        if (start >= end) {
            return 0;
        }
        long count = 0;
        int mid = (end + start) / 2;
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                count += mid - left + 1;
                tempArr[index++] = arr[right++];
            } else {
                tempArr[index++] = arr[left++];
            }
        }
        while (left <= mid) {
            tempArr[index++] = arr[left++];
        }
        while (right <= end) {
            tempArr[index++] = arr[right++];
        }
        for (index = start; index <= end; index++) {
            arr[index] = tempArr[index];
        }
        return count % 1000000007;
    }
    
    public static void main(String[] args) {
    
    }
}
