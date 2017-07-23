package code.interviews;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * @author haroldcoding
 * @create 2017/07/18/19:18
 */
public class Number25 {
    
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        ArrayList<Integer> path = new ArrayList<>();
        judgePath(root, target, result, path);
        return result;
    }
    
    private static void judgePath(TreeNode node, int target,
        ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        path.add(node.val);
        boolean isEnd = node.left == null && node.right == null;
        if (node.val == target && isEnd) {
            result.add(path);
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>();
        path2.addAll(path);
        if (node.left != null) {
            judgePath(node.left, target - node.val, result, path);
        }
        if (node.right != null) {
            judgePath(node.right, target - node.val, result, path2);
        }
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        ArrayList<ArrayList<Integer>> pathList = findPath(n1, 22);
        for (ArrayList<Integer> path : pathList) {
            for (int i : path) {
                System.out.println(i);
            }
            System.out.println("===================");
        }
    }
    
}
