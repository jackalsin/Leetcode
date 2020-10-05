package microsoft.noodleEssence._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MinStackTwoStackSolution implements MinStack {
  private final Deque<Integer> stack = new ArrayDeque<>(),
      minStack = new ArrayDeque<>();

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty() || minStack.peek() >= x) {
      minStack.push(x);
    }
  }

  public void pop() {
    assert !stack.isEmpty() && !minStack.isEmpty();
    final int res = stack.pop();
    if (res == minStack.peek()) {
      minStack.pop();
    }
  }

  public int top() {
    assert !stack.isEmpty();
    return stack.peek();
  }

  public int getMin() {
    assert !minStack.isEmpty();
    return minStack.peek();
  }

}
