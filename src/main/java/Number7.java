import java.util.Stack;

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
     * 第一次的写法：stack1 在入栈结束后为空，stack2 保存所有的数据
     * 每入栈一个值都要先 stack2 弹出到 stack1 然后在 入栈，最后将stack1 弹出到 stack2 以完成追加数据到队
     * 尾的操作。
     */
    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    
    
    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }
}
