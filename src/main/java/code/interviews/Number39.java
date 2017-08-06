package code.interviews;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 二叉树的深度
 *
 * @author haroldcoding
 * @create 2017/08/06/18:18
 */
public class Number39 {
    
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
    
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] path = new int[1];
        path(root, path, res);
        Collections.sort(res);
        return res.get(res.size() - 1);
    }
    
    private static void path(TreeNode node, int[] path, ArrayList<Integer> res) {
        if (node.left == null && node.right == null) {
            res.add(path[0] + 1);
            return;
        }
        path[0] += 1;
        if (node.left != null) {
            path(node.left, path, res);
        }
        if (node.right != null) {
            int[] p = {path[0]};
            path(node.right, p, res);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);
        System.out.println(solution(root));
    }
}
