package code.interviews;

import java.util.Stack;

/**
 * 求两个链表的公共结点
 *
 * 如果链表要从尾部开始比较，可以考虑使用栈
 * @author haroldcoding
 * @create 2017/08/06/15:52
 */
public class Number37 {
    
    public static ListNode solution1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        
        int p1Length = getLinkLength(pHead1);
        int p2Length = getLinkLength(pHead2);
        int step = p1Length > p2Length ? p1Length - p2Length : p2Length - p1Length;
        ListNode shortLenLink = p1Length > p2Length ? pHead2 : pHead1;
        ListNode longLenLink = p1Length > p2Length ? pHead1 : pHead2;
        while (step != 0) {
            longLenLink = longLenLink.next;
            --step;
        }
        while (shortLenLink != null && longLenLink != null) {
            if (shortLenLink == longLenLink) {
                return shortLenLink;
            } else {
                shortLenLink = shortLenLink.next;
                longLenLink = longLenLink.next;
            }
        }
        return null;
    }
    
    private static int getLinkLength(ListNode head) {
        int res = 1;
        while (head != null) {
            ++res;
            head = head.next;
        }
        return res;
    }
    
    public static ListNode solution(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode l1 = stack1.pop();
            ListNode l2 = stack2.pop();
            if (l1 == l2 && (stack1.isEmpty() || stack2.isEmpty()
                || (stack1.peek() != stack2.peek()))) {
                return l1;
            }
        }
        return null;
    }
    
}
