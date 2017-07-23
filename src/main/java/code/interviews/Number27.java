package code.interviews;

/**
 * @author haroldcoding
 * @create 2017/07/23/14:42
 */
public class Number27 {
    
    public TreeNode convert(TreeNode pRootOfTree) {
        // 保存转换后的双向链表的尾结点
        TreeNode[] lastNode = new TreeNode[1];
        convertNode(pRootOfTree, lastNode);
        TreeNode head = lastNode[0];
        // 找到头结点
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }
    
    /**
     * 转换链表
     *
     * @param node 当前结点
     * @param lastNode 长度1的数组储存转换后双向链表的尾结点
     */
    public void convertNode(TreeNode node, TreeNode[] lastNode) {
        if (node == null) {
            return;
        }
        // 先处理左子树
        if (node.left != null) {
            convertNode(node.left, lastNode);
        }
        node.left = lastNode[0];
        // 当转换后的双向链表不为空时
        if (lastNode[0] != null) {
            lastNode[0].right = node;
        }
        lastNode[0] = node;
        //处理右子树
        if (node.right != null) {
            convertNode(node.right, lastNode);
        }
    }
    
}
