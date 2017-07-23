package code.interviews;

import java.util.ArrayList;
import java.util.List;

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
     * 思路：
     * 利用 ArrayList 保存每层的结点；
     * 每次循环，遍历当前 list 中的所有结点并交换结点的左右叶节点，然后保存非空的左右叶结点，也就是下一层的结点；
     * 当 list 元素数为 0 时，就完成了所有结点的交换，得到了树的景象
     *
     */
    public static void mirrorCircle(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        treeNodes.add(root);
        while (true) {
            // 当保存结点左右结点的 list 长度为 0 时，说明完成了遍历，跳出循环
            if (treeNodes.size() == 0) {
                break;
            }
            int size = treeNodes.size();
            // 临时 list 保存非空左右结点
            List<TreeNode> tempNodeList = new ArrayList<TreeNode>();
            // 遍历当前 list 中的结点，交换该结点的左右结点，然后将非空的左右结点保存在临时 list 中
            for (int i = 0; i < size; i++) {
                if (treeNodes.get(i).left == null && treeNodes.get(i).right == null) {
                    continue;
                }
                TreeNode temp = treeNodes.get(i).left;
                treeNodes.get(i).left = treeNodes.get(i).right;
                treeNodes.get(i).right = temp;
                if (treeNodes.get(i).left != null) {
                    tempNodeList.add(treeNodes.get(i).left);
                }
                if (treeNodes.get(i).right != null) {
                    tempNodeList.add(treeNodes.get(i).right);
                }
            }
            treeNodes = tempNodeList;
        }
    }
}
