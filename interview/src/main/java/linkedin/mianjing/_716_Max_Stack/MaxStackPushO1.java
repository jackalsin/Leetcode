package linkedin.mianjing._716_Max_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MaxStackPushO1 implements MaxStack {
  private final Deque<Integer> stack = new ArrayDeque<>(), maxStack = new ArrayDeque<>();

  @Override
  public void push(int x) {
    int max = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
    max = Math.max(max, x);
    stack.push(x);
    maxStack.push(max);
  }

  @Override
  public int pop() {
    maxStack.pop();
    return stack.pop();
  }

  @Override
  public int top() {
    return stack.peek();
  }

  @Override
  public int peekMax() {
    return maxStack.peek();
  }

  @Override
  public int popMax() {
    final int max = maxStack.peek();
    final Deque<Integer> temp = new ArrayDeque<>();
    while (stack.peek() != max) {
      temp.push(stack.pop());
      maxStack.pop();
    }
    stack.pop();
    maxStack.pop();
    while (!temp.isEmpty()) {
      push(temp.pop());
    }

    return max;
  }
}
