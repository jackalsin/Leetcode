package apple._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public final class MinStackI implements MinStack {
  private long min = Long.MAX_VALUE;
  private final Deque<Long> stack = new ArrayDeque<>();

  public void push(int x) {
    if (min >= x) {
      stack.push(min);
      min = x;
    }
    stack.push((long) x);
  }

  public void pop() {
    final int res = (int) (long) (stack.remove());
    if (!stack.isEmpty() && res == min) {
      min = stack.pop();
    }
  }

  public int top() {
    assert !stack.isEmpty();
    return (int) (long) (stack.peek());
  }

  public int getMin() {
    return (int) min;
  }
}
