package interviews.linkedin._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MinStack1Stacks implements MinStack {
  private final Deque<Integer> stack = new ArrayDeque<>();
  private int min = Integer.MAX_VALUE;

  public void push(int x) {
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    final int res = stack.pop();
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
