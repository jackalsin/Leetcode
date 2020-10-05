package pureStorage._0155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class TwoStackSolution implements MinStack {
  private int min = Integer.MAX_VALUE;
  private final Deque<Integer> stack = new ArrayDeque<>(),
      minStack = new ArrayDeque<>();

  public void push(int x) {
    stack.push(x);
    minStack.push(min);
    min = Math.min(min, x);
  }

  public void pop() {
    assert !stack.isEmpty();
    min = minStack.pop();
    stack.pop();
  }

  public int top() {
    assert !stack.isEmpty();
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
