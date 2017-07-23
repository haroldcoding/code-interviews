package code.interviews; /**
 * 剑指 offer 面试题5：
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * @author haroldcoding
 * @create 2017/07/08/16:19
 */

import java.util.ArrayList;
import java.util.Stack;



public class Number5 {
    
    /**
     * 第一次思路：
     * 遍历整个链表，将每个值放入一个临时 ArrayList, 然后将该临时 ArrayList 反转输出.
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (null == listNode) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (null != listNode) {
            temp.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
        return result;
    }
    
    /**
     * 剑指offer 上的思路 ：遍历链表是从头到尾的顺序，但输出值却是从尾到头，即”后进先出”，所以考虑用栈实现这种顺序.
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        while (listNode != null) {
            temp.push(listNode.val);
            listNode = listNode.next;
        }
        while (!temp.isEmpty()) {
            result.add(temp.pop());
        }
        return result;
    }
    
    /**
     * 递归实现.
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        addListNodeValue(listNode, result);
        
        return result;
    }
    
    private void addListNodeValue(ListNode listNode, ArrayList<Integer> arrayList) {
        if (listNode.next != null) {
            addListNodeValue(listNode.next, arrayList);
        }
        arrayList.add(listNode.val);
        
    }
}
