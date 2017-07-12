/**
 * 二叉树的镜像
 *
 * @author haroldcoding
 * @create 2017/07/12/21:41
 */
public class Number19 {
    
    /**
     * 递归实现
     */
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
    
    /**
     * 循环实现
     */
    public static void mirrorCircle(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode[] treeNodes = {root};
        int level = 1;
        
    }
}
