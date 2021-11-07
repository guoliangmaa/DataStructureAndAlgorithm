package leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack , min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (min.isEmpty() || min.peek() >= x) min.push(x);  //注意一定是大于等于!
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min.peek()) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}

