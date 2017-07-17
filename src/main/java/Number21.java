
import java.util.Stack;

/**
 * 包含 min 函数的栈
 *
 * @author haroldcoding
 * @create 2017/07/17/14:18
 */
public class Number21 {
    
    private Stack<Integer> minOfStack = new Stack<>();
    private Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int node) {
        stack.push(node);
        if (minOfStack.isEmpty()) {
            minOfStack.push(node);
        } else {
            if (node < minOfStack.peek()) {
                minOfStack.push(node);
            } else {
                minOfStack.push(minOfStack.peek());
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        stack.pop();
        minOfStack.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int topOfStack = stack.pop();
        minOfStack.pop();
        return topOfStack;
    }
    
    public int min() {
        return minOfStack.peek();
    }
    public static void main(String[] args){
        Number21 stack = new Number21();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.min());
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }
}
