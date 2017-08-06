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
    
    /**
     * 判断是否是平衡二叉树
     * 通过先求出左右子树的深度然后判断左右子树深度差是不是小于1，如果是，再判读左右子树是不是都是平衡二叉树；如果
     * 大于1，说明不是平衡二叉树；
     * 这种方法弊端在于: 重复遍历了结点，在求子树深度和子树是不是平衡二叉树的时候都遍历了一遍结点，
     * 所以
     * 如果采用后序遍历，那么在访问到该结点的时候，它的左右子树都已经访问过了，所以如果用一个全局的boolean标识某一个子树
     * 是不是平衡二叉树，那么此时应该已经直到它的左右子树是不是平衡二叉树了，并且左右子树的深度也可以获得，这样就在遍历一遍
     * 结点的情况下完成判断，解法见 isBalanced2(TreeNode root)
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    /**
     * 通过后序遍历判断是否是平衡二叉树
     *
     * 后序遍历只需要遍历一遍结点
     */
    public static boolean isBalanced2(TreeNode root, int[] path) {
        // 全局变量，标识某一个子树是不是平衡二叉树
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }
    
    private static int getHeight(TreeNode node, int level, boolean[] res) {
        if (node == null) {
            return level;
        }
        int leftH = getHeight(node.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rightH = getHeight(node.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(leftH - rightH) > 1) {
            res[0] = false;
        }
        return Math.max(rightH, leftH);
    }
    
    /**
     * 记录下每一条路径的长度，取最大值就是二叉树的深度
     */
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
    
    /**
     * 记录下每一条路径的长度
     */
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
        System.out.println(isBalanced2(root, new int[1]));
    }
}
