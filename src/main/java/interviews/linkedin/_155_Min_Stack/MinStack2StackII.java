package interviews.linkedin._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/28/2019
 */
public final class MinStack2StackII implements MinStack {
  private final Deque<Integer> stack = new ArrayDeque<>(),
      minStack = new ArrayDeque<>();
  private int min = Integer.MAX_VALUE;

  public void push(int x) {
    minStack.push(min);
    min = Math.min(min, x);
    stack.push(x);
  }

  public void pop() {
    assert !stack.isEmpty();
    stack.pop();
    min = minStack.pop();
  }

  public int top() {
    assert !stack.isEmpty();
    return stack.peek();
  }

  public int getMin() {
    assert !stack.isEmpty();
    return min;
  }
}
