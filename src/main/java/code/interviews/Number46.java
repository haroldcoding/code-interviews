package code.interviews;

/**
 * @author haroldcoding
 * @create 2017/08/09/16:47
 */
public class Number46 {
    
    public static int solution(int n) {
        int result = 0;
        int a = 1;
        boolean continueSum = (n != 0) && a == (result = solution(n - 1));
        result += n;
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(2));
    }
    
    
}
