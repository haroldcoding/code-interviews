
/**
 * 反转链表
 *
 * @author haroldcoding
 * @create 2017/07/11/23:36
 */
public class Number16 {
    
    public static ListNode reverseList(ListNode head) {
        // 头结点为空,或只有一个头结点
        if (head == null || head.next == null) {
            return head;
        }
        // 原链表中前一个结点
        ListNode previousNode = head;
        // 原链表当前结点
        ListNode currentNode = head.next;
        // 原链表当前结点的下一个节点
        ListNode nextNode = null;
        while (currentNode != null) {
            if (previousNode == head) {
                previousNode.next = null;
            }
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
    
    /**
     * 递归实现
     */
    public static ListNode reverseListUseRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        ListNode reverseHeadNode = reverseListUseRecursion(nextNode);
        nextNode.next = head;
        return reverseHeadNode;
        
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

//        ListNode temp = reverseList(n1);
//        while (temp != null) {
//            System.out.print(temp.val + "-->");
//            temp = temp.next;
//        }
//        System.out.println("null");
        
        ListNode temp1 = reverseListUseRecursion(n1);
        while (temp1 != null) {
            System.out.print(temp1.val + "-->");
            temp1 = temp1.next;
        }
        System.out.println("null");
    }
}
