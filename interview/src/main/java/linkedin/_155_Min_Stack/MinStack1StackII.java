package linkedin._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MinStack1StackII implements MinStack {
  private final Deque<Integer> stack = new ArrayDeque<>();
  private int min = Integer.MAX_VALUE;

  public void push(int x) {
    if (min >= x) {
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
    assert !stack.isEmpty();
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
