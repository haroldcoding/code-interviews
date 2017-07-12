import java.util.List;

/**
 * 合并两个递增的链表
 *
 * @author haroldcoding
 * @create 2017/07/12/9:50
 */
public class Number17 {
    
    public static ListNode merge(ListNode list1, ListNode list2) {
        
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val >= list2.val) {
            head = list2;
            head.next = merge(list1, list2.next);
        } else {
            head = list1;
            head.next = merge(list1.next, list2);
        }
        return head;
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
        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(7);
        ListNode m3 = new ListNode(8);
        ListNode m4 = new ListNode(9);
        ListNode m5 = new ListNode(10);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        // ListNode tempHead = merge(n1, m1);
        ListNode tempHead = merge(m1, n1);
        while (tempHead != null) {
            System.out.print(tempHead.val + "-->");
            tempHead = tempHead.next;
        }
        System.out.println("null");
    }
}
