package code.interviews;

import java.util.ArrayList;

/**
 * @author haroldcoding
 * @create 2017/08/06/22:44
 */
public class Number41 {
    
    /**
     * 递增数组数找到和为k的两个数，如果有多对输出任意一对即可
     */
    public static int[] solution(int[] array, int k) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = array.length - 1;
        int[] res = new int[2];
        int sum = 0;
        while (left != right) {
            sum = array[left] + array[right];
            if (sum > k) {
                --right;
            } else if (sum < k) {
                ++left;
            } else {
                res[0] = array[left];
                res[1] = array[right];
                break;
            }
        }
        return res;
    }
    
    /**
     * 连续序列和为sum 的所有序列
     */
    public static ArrayList<ArrayList<Integer>> solution(int sum) {
        if (sum < 3) {
            return new ArrayList<ArrayList<Integer>>();
        }
        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int sumArr = small + big;
        while (small < mid) {
            if (sumArr == sum) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    temp.add(i);
                }
                res.add(temp);
                ++big;
                sumArr += big;
            } else if (sumArr > sum) {
                sumArr -= small;
                ++small;
            } else {
                ++big;
                sumArr += big;
            }
        }
        return res;
    }
    
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<Integer>();
        }
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int max = 0;
        int twoSum = 0;
        while (left != right) {
            twoSum = array[left] + array[right];
            if (twoSum > sum) {
                --right;
            } else if (twoSum < sum) {
                ++left;
            } else {
                int t = array[left] * array[right];
                if (res.size() == 0) {
                    res.add(array[left]);
                    res.add(array[right]);
                } else if (max > t) {
                    res.set(0, array[left]);
                    res.set(1, array[right]);
                }
                max = t;
                --right;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        ArrayList<Integer> r = findNumbersWithSum(array, 15);
        for (int i : r) {
            System.out.print(i + " ");
        }
        System.out.println();
        ArrayList<ArrayList<Integer>> res = solution(15);
        for (ArrayList<Integer> item : res) {
            for (int i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
