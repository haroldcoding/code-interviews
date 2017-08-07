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
     * @param sum
     * @return
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
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = solution(15);
        for (ArrayList<Integer> item : res) {
            for (int i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
