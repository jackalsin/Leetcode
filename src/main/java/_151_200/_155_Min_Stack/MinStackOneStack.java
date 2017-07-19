package _151_200._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackOneStack {
    private int min;
    private final Deque<Integer> stack;

    public MinStackOneStack() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int res = stack.pop();
        if (res == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
