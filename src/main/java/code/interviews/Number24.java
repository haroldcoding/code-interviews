package code.interviews;

/**
 * 二叉搜索树后序遍历序列
 *
 * @author haroldcoding
 * @create 2017/07/18/16:09
 */
public class Number24 {
    
    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        return isCorrectOrder(sequence, 0, sequence.length);
    }
    
    private static boolean isCorrectOrder(int[] sequence, int start, int length) {
        if (sequence == null || length <= 0) {
            return false;
        }
        // 根结点值
        int root = sequence[length - 1];
        int leftEndIndex = start;
        // 找到左子树最后一个元素的索引
        for (; leftEndIndex < length - 1; leftEndIndex++) {
            if (sequence[leftEndIndex] > root) {
                break;
            }
        }
        int rightEndIndex = leftEndIndex;
        // 判断剩余元素是否为右子树元素，如果存在小于根结点值的结点，返回 false
        for (; rightEndIndex < length - 1; rightEndIndex++) {
            if (sequence[rightEndIndex] < root) {
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树
        boolean leftIsBT = true;
        if (leftEndIndex > 0) {
            leftIsBT = isCorrectOrder(sequence, 0, leftEndIndex);
        }
        // 判断右子树是不是二叉搜索树
        boolean rightIsBT = true;
        if (leftEndIndex < length - 1) {
            rightIsBT = isCorrectOrder(sequence, leftEndIndex, length - leftEndIndex - 1);
        }
        // 左右子树均为二叉搜索树返回 true
        return leftIsBT && rightIsBT;
    }
    
    
}
