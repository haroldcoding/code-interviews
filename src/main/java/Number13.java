/**
 * 在O(1)时间删除单项链表节点.
 *
 * @author haroldcoding
 * @create 2017/07/11/16:05
 */
public class Number13 {
    
    public static ListNode deleteNode(ListNode listHead, ListNode toBeDeletedNode) {
        if (listHead == null || toBeDeletedNode == null) {
            return listHead;
        }
        // 当要删除的链表节点不是尾节点时，将该节点的下一个节点复制到该节点上，然后指向该节点下个节点的下个节点，即完成删除
        if (toBeDeletedNode.next != null) {
            toBeDeletedNode.val = toBeDeletedNode.next.val;
            toBeDeletedNode.next = toBeDeletedNode.next.next;
        } else { //当要删除的节点是尾节点时，就需要从头遍历，找到该节点的前一个节点，将其指向 null 即可.
            ListNode temp = listHead;
            while (temp.next != null) {
                if (temp.next != toBeDeletedNode) {
                    temp = temp.next;
                } else {
                    temp.next = null;
                }
            }
        }
        return listHead;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        // deleteNode(n1, n5);
        deleteNode(n1, n1);
        ListNode temp = n1;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
