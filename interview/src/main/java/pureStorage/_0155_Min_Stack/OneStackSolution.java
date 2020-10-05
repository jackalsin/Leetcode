package pureStorage._0155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class OneStackSolution implements MinStack {
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
    final int res = stack.pop();
    if (min == res) {
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
