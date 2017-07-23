package code.interviews;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author haroldcoding
 * @create 2017/07/18/15:44
 */
public class Number23 {
    
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (true) {
            if (nodeList.isEmpty()) {
                break;
            }
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (TreeNode item : nodeList) {
                result.add(item.val);
                if (item.left != null) {
                    temp.add(item.left);
                }
                if (item.right != null) {
                    temp.add(item.right);
                }
            }
            nodeList = temp;
        }
        return result;
        
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        ArrayList<Integer> result = printFromTopToBottom(n1);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
