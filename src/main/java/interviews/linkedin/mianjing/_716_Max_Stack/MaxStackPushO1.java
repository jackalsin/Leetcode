package interviews.linkedin.mianjing._716_Max_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/4/18
 */
public final class MaxStackPushO1 implements MaxStack {
  private final Deque<Integer> stack = new ArrayDeque<>(), maxStack = new ArrayDeque<>();

  @Override
  public void push(int x) {
    int temp = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
    temp = Math.max(x, temp);

    stack.push(x);
    maxStack.push(temp);
  }

  @Override
  public int pop() {
    maxStack.pop();
    return stack.pop();
  }

  @Override
  public int top() {
    assert !stack.isEmpty();
    return stack.peek();
  }

  @Override
  public int peekMax() {
    assert !maxStack.isEmpty();
    return maxStack.peek();
  }

  @Override
  public int popMax() {

    final Deque<Integer> pop = new ArrayDeque<>();
    final int max = maxStack.peek();
    assert stack.peek() != null;
    while (!stack.peek().equals(max)) {
      pop.push(stack.pop());
      maxStack.pop();
    }
    final int res = stack.pop();
    maxStack.pop();

    while (!pop.isEmpty()) {
      push(pop.pop());
    }

    return res;
  }
}
