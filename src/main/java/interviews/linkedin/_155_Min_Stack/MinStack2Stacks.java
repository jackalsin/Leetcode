package interviews.linkedin._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MinStack2Stacks implements MinStack {
  private final Deque<Integer> stack = new ArrayDeque<>(),
      minStack = new ArrayDeque<>();

  public void push(int x) {
    stack.push(x);
    final int min = minStack.isEmpty() ? x : Math.min(minStack.peek(), x);
    minStack.push(min);
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

}
