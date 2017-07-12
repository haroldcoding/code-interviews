

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author haroldcoding
 * @create 2017/07/12/11:36
 */
public class Number18 {
    
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //先判断根节点相同
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            // 根节点不同，遍历左子树
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            // 左子树没有，遍历右子树
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }
    
    private static boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right,
            root2.right);
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
        TreeNode m1 = new TreeNode(3);
        TreeNode m2 = new TreeNode(6);
        TreeNode m3 = new TreeNode(7);
        m1.left = m2;
        m1.right = m3;
        System.out.println(hasSubtree(null, null));
        System.out.println(hasSubtree(n1, null));
        System.out.println(hasSubtree(null, n2));
        System.out.println(hasSubtree(n1, m1));
    }
}
