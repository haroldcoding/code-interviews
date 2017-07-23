package code.interviews;

/**
 * 位运算：输入一个整数，判断该整数二进制中1的个数
 * 负数用补码表示
 *
 * @author haroldcoding
 * @create 2017/07/09/21:30
 */
public class Number10 {
    
    public int numberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            
            if ((n & flag) != 0) {
                count++;
            }
            
            flag = flag << 1;
        }
        return count;
    }
    
    public int numberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
    
    /**
     * 输入两个整数 m , n 求该变 m 的二进制表示中的多少位才能得到 n.
     */
    public int changeNumber(int m, int n) {
        int temp = m ^ n;
        int count = 0;
        while (temp != 0) {
            ++count;
            temp = (temp - 1) & temp;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Number10 n = new Number10();
        System.out.println(n.numberOf1(10));
    }
}
