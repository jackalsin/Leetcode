package _151_200._155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MinStackO1Space implements MinStack {
  private int min;
  private final Deque<Integer> stack;

  public MinStackO1Space() {
    stack = new ArrayDeque<>();
    min = Integer.MAX_VALUE;
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      min = x;
    }

    if (x < min) {
      // the element we insert will be smaller than the new min, which is x
      stack.push(2 * x - min);
      min = x;
    } else {
      stack.push(x);
    }
  }

  public void pop() {
    assert !stack.isEmpty();
    if (min > stack.peek()) {
      // the min is going to be popped;
      final int res = stack.pop();
      min = 2 * min - res;
    } else {
      stack.pop();
    }
  }

  public int top() {
    assert !stack.isEmpty();
    if (min > stack.peek()) {
      // the min is going to peek();
      return min;
    } else {
      return stack.peek();
    }
  }

  public int getMin() {
    return min;
  }
}
