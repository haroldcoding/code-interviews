package code.interviews;

import java.util.ArrayList;

/**
 * @author haroldcoding
 * @create 2017/08/09/15:06
 */
public class Number45 {
    
    public static int solution(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            if (cur == list.size()) {
                cur = 0;
            }
        }
        return list.get(cur);
    }
    
    /**
     * 利用递归
     * @param n
     * @param m
     * @return
     */
    public static int solution2(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        return getLive(n, m) - 1;
    }
    
    /**
     * 编号从1 到 n 时，最后剩下的编号，利用递归
     * @param i
     * @param m
     * @return 最后剩下的编号
     */
    public static int getLive(int i, int m) {
        if (i == 1) {
            return i;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }
    
    public static int solution3(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        return getLiveUseCircle(n, m) - 1;
    }
    
    /**
     * 利用循环
     * @param n
     * @param m
     * @return
     */
    public static int getLiveUseCircle(int n, int m) {
        if (n == 1) {
            return n;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res + m - 1) % i + 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(5, 3));
        System.out.println(solution2(5, 3));
        System.out.println(solution3(5, 3));
    }
}
