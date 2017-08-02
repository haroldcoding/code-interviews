package code.interviews;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 最小的k个数
 *
 * @author haroldcoding
 * @create 2017/08/01/9:03
 */
public class Number30 {
    
    /**
     * 方法1： 利用快速排序
     *
     * @param input 输入数组
     * @param k 需要返回的数的个数
     * @return 最小的k个数
     */
    public static ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k > input.length) {
            return result;
        }
        int arrLength = input.length;
        quickSort(input, 0, arrLength - 1);
        for (int i = 0; i < k && i < arrLength; i++) {
            result.add(input[i]);
        }
        return result;
    }
    
    private static int partition(int[] arr, int start, int end) {
        int center = (start + end) >> 1;
        if (arr[center] < arr[start]) {
            swap(arr, start, center);
        }
        if (arr[end] < arr[start]) {
            swap(arr, start, end);
        }
        if (arr[end] < arr[center]) {
            swap(arr, start, end);
        }
        swap(arr, center, end - 1);
        return arr[end - 1];
    }
    
    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (start + 10 <= end) {
            int pivot = partition(arr, start, end);
            int left = start + 1;
            int right = end - 2;
            while (left < right) {
                while (arr[left] < pivot && left < right) {
                    left++;
                }
                while (arr[right] > pivot && left < right) {
                    right--;
                }
                if (left < right) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }
            }
            swap(arr, left, end - 1);
            quickSort(arr, start, left - 1);
            quickSort(arr, left + 1, end);
        } else {
            for (int i = 1, size = arr.length; i < size; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i - 1, i);
                    for (int j = i - 1; j > 0; j--) {
                        if (arr[j - 1] > arr[j]) {
                            swap(arr, j - 1, j);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 方法2 ：维护一个有k个数的最大堆，这个堆代表目前选出来的k个最小的数，在堆里的k个元素中堆顶的元素是最小的k个数里 最大的那个。然后遍历数组，在过程中，只有当前数比堆顶数小的时候，替换堆顶数，然后调整堆，维持堆顶数为当前堆中的最大数，
     * 否则就不做任何操作，遍历结束后，这个堆就是数组中k个最小的数。
     */
    public static ArrayList<Integer> getMinKNUmsByHeap(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k > input.length || k < 1) {
            return result;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, input[i], i);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < kHeap[0]) {
                kHeap[0] = input[i];
                heapAdjust(input, 0, k);
            }
        }
        for (int i : kHeap) {
            result.add(i);
        }
        return result;
    }
    
    private static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    
    private static void heapAdjust(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = index;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
    
    /**
     * 利用BFPRT算法
     */
    public static ArrayList<Integer> getMinKNumsByBFPRT(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (k < 1 || input == null || input.length == 0 || k > input.length) {
            return result;
        }
        
        int index = 0;
        int minKth = getMinKthByBFPRT(input, k);
        int[] res = new int[k];
        for (int i = 0; i != input.length; i++) {
            if (input[i] < minKth) {
                res[index++] = input[i];
            }
        }
        for (; index < k; index++) {
            res[index] = minKth;
        }
        for (int j : res) {
            result.add(j);
        }
        return result;
    }
    
    private static int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        return select(copyArr, 0, copyArr.length - 1, k);
    }
    
    /**
     * 取第i小的数
     * 先取一个 pivot 然后根据pivot 将数组分区，小的放左边，大的放右边，相等的放中间，并得到相等的这部分数范围的上下界，
     * 如果 k 落在了 范围中，直接返回，如果落在了上界外，则到上界的范围寻找，如果落在了下界外，则在下界返回继续寻找。
     * @param arr 数组
     * @param start 范围上界
     * @param end 范围下界
     * @return 第i小的数
     */
    private static int select(int[] arr, int start, int end, int i) {
        if (start == end) {
            return arr[start];
        }
        int pivot = medianOfMedians(arr, start, end);
        int[] pivotRange = partition(arr, start, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return select(arr, start, pivotRange[0] - 1, i);
        } else {
            return select(arr, pivotRange[1] + 1, end, i);
        }
    }
    
    /**
     * 将数组根据pivot分区，比pivot小的放左边，大的放右边，相等的放中间
     * @param arr 源数组
     * @param start 范围上界
     * @param end 范围下界
     * @param pivot 枢纽元
     * @return 与pivot相等的范围上下界
     */
    private static int[] partition(int[] arr, int start, int end, int pivot) {
        int small = start - 1;
        int cur = start;
        int big = end + 1;
        // 比 pivot小的放左边，比pivot大的放右边，相等的放中间
        // 可以看做是一个“荷兰国旗”排序问题
        while (cur != big) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        // 因为 small 始终指向前一个排好位置的比pivot小的数，所以最终指向最后一个比pivot小的数
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }
    
    /**
     * 取数组中指定范围的中位数
     * @param arr 源数组
     * @param start 范围上界
     * @param end 范围下界
     * @return 指定范围的中位数
     */
    private static int medianOfMedians(int[] arr, int start, int end) {
        int num = end - start + 2;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0, length = mArr.length; i < length; i++) {
            int begainI = start + i * 5;
            int endI = begainI + 4;
            mArr[i] = getMedian(arr, begainI, Math.min(endI, end));
        }
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }
    
    /**
     * 找到数组中指定范围的中位数
     *
     * @param arr 数组
     * @param start 范围上界
     * @param end 范围下界
     * @return 指定范围的中位数
     */
    private static int getMedian(int[] arr, int start, int end) {
        insertSort(arr, start, end);
        int sum = end + start;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }
    
    /**
     * 对数组中指定范围插入排序
     *
     * @param arr 数组
     * @param start 范围上界
     * @param end 范围下界
     */
    private static void insertSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= Math.min(end, arr.length); i++) {
            for (int j = i; j != start; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
}
