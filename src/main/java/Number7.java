import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 题目描述：
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：
 * 一个栈正常插入元素，此时元素读取顺序为“先进后出”，这显然不能满足要求，所以将该栈的元素保存到另一个栈中，那么先进的元
 * 素就位于第二个栈的栈顶，当要读取元素时从第二个栈读取即实现了“先进先出”的顺序，满足队列的特征。
 *
 * @author haroldcoding
 * @create 2017/07/09/10:24
 */
public class Number7 {
    
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    /**
     * 参考剑指offer和《程序员代码面试指南》：
     * 用两个栈实现队列，假设 stack1 用于入队， stack2 用于出队，那么要保证元素的先进先出就必须满足以下两点：
     * 1. 当 stack2 不为空的时候，不能将 stack1 中的元素压入 stack2
     * 2. 当stack1 的元素压入 stack2 中时，必须将 stack1 中的元素全部压入 stack2
     */
    public void push2(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
    }
    
    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }
    
    /**
     * 用两个队列实现栈.
     */
    Queue<Integer> queuePush = new ConcurrentLinkedDeque<>();
    Queue<Integer> queuePop = new ConcurrentLinkedDeque<>();
    
    public void push(int node) {
        queuePush.offer(node);
        
    }
    
    public int pop2() {
        if (queuePush.isEmpty() && queuePop.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        if (queuePush.isEmpty()) {
            while (queuePop.size() != 1) {
                queuePush.offer(queuePop.poll());
            }
            return queuePop.poll();
        }
        while (queuePush.size() != 1) {
            queuePop.offer(queuePush.poll());
        }
        return queuePush.poll();
    }
    
    
}
