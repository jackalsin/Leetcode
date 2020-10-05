package _0151_0200._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MinStackTwoStack implements MinStack {
  private final Deque<Integer> stack1;
  private final Deque<Integer> minValueStack;

  public MinStackTwoStack() {
    stack1 = new ArrayDeque<>();
    minValueStack = new ArrayDeque<>();
  }

  public void push(int x) {
    if (minValueStack.size() == 0 || x <= getMin()) {
      minValueStack.push(x);
    }
    stack1.push(x);
  }

  public void pop() {
    if (stack1.peek().equals(minValueStack.peek())) {
      minValueStack.pop();
    }
    stack1.pop();
  }

  public int top() {
    return stack1.peek();
  }

  public int getMin() {
    return minValueStack.peek();
  }
}
