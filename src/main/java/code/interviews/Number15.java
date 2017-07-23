package code.interviews;

/**
 * 输入一个链表，输出该链表中倒数第 k 个节点.
 *
 * @author haroldcoding
 * @create 2017/07/11/23:18
 */
public class Number15 {
    
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode temp = head;
        int linkedListSize = 0;
        while (temp != null) {
            ++linkedListSize;
            temp = temp.next;
        }
        if (k > linkedListSize) {
            return null;
        }
        temp = head;
        int skipSize = linkedListSize - k;
        while (skipSize > 0) {
            temp = temp.next;
            skipSize--;
        }
        return temp;
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
        System.out.println(findKthToTail(n1,1).val);
    }
}
