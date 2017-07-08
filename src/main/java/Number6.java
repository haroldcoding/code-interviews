import java.util.Arrays;

/**
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字.
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回.
 *
 * @author haroldcoding
 * @create 2017/07/08/17:26
 */
public class Number6 {
    
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0
            || pre.length != in.length) {
            return null;
        }
        TreeNode rootNode = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return rootNode;
    }
    
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
        int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startIn] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn,
                    in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre,
                    in, i + 1, endIn);
            }
        }
        return root;
    }
    
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0
            || pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0, length = in.length; i < length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                    Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                    Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}
