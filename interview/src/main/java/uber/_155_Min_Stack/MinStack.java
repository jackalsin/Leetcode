package uber._155_Min_Stack;

import java.util.Stack;

public final class MinStack {
  /**
   * Store
   * the diff with min when the pushed <code>x</code> is larger than or equals to the min
   * Or
   * the diff with the previous min when smaller.
   */
  private final Stack<Long> stack = new Stack<>();
  private long min;

  /**
   * initialize your data structure here.
   */
  public MinStack() {

  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(0L);
      min = x;
    } else {
      stack.push((long) x - min);
      if (x < min) {
        min = x;
      }
    }
  }

  public void pop() {
    if (stack.isEmpty()) {
      return;
    }

    long res = stack.pop();
    if (res < 0) {
      min -= res;
    }
  }

  public int top() {
    long top = stack.peek();
    if (top > 0) {
      return (int) (top + min);
    }
    return (int) min;
  }

  public int getMin() {
    return (int) min;
  }
}
