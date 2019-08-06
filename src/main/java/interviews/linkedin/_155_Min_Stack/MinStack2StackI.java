package interviews.linkedin._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/5/2019
 */
public final class MinStack2StackI implements MinStack {
  private final Deque<Integer> stack = new ArrayDeque<>(),
      minStack = new ArrayDeque<>();
  private int min = Integer.MAX_VALUE;

  public void push(int x) {
    stack.push(x);
    minStack.push(min);
    min = Math.min(min, x);
  }


  public void pop() {
    stack.pop();
    min = minStack.pop();
  }


  public int top() {
    return stack.peek();
  }


  public int getMin() {
    return min;
  }
}
