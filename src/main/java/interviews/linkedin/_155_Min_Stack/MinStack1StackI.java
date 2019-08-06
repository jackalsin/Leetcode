package interviews.linkedin._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/5/2019
 */
public final class MinStack1StackI implements MinStack {
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
    final int cur = stack.pop();
    if (cur == min) {
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
