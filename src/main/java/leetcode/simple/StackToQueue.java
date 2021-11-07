package leetcode.simple;

import java.util.Stack;

//两个栈实现队列
public class StackToQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
       stack2.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) return stack1.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }
}
