import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序
 * 列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * @author haroldcoding
 * @create 2017/07/17/15:32
 */
public class Number22 {
    
    public boolean isPopOrder(int[] pushA, int[] popA) {
        
        if (pushA == null || popA == null || pushA.length != popA.length || pushA.length == 0) {
            return false;
        }
        ArrayList<Integer> stack = new ArrayList<>();
        int equalsNumberIndex = 0;
        for (int i = 0, length = popA.length; i < length; i++) {
            if (!stack.isEmpty() && stack.get(stack.size() - 1) == popA[i]) {
                stack.remove(stack.size() - 1);
            } else {
                int index = -1;
                for (int j = equalsNumberIndex, pushLength = pushA.length; j < pushLength; j++) {
                    if (pushA[j] != popA[i]) {
                        stack.add(pushA[j]);
                    } else {
                        equalsNumberIndex = j + 1;
                        index = j;
                        break;
                    }
                }
                if (index < 0) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
