package byteDance._232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class MyQueueI implements MyQueue {
  // push to stack2, pop from stack 1
  private final Deque<Integer> stack1 = new ArrayDeque<>(),
      stack2 = new ArrayDeque<>();

  public void push(int x) {
    stack2.push(x);
  }

  public int pop() {
    fillStack1IfEmpty();
    return stack1.pop();
  }

  public int peek() {
    fillStack1IfEmpty();
    assert !stack1.isEmpty();
    return stack1.peek();
  }

  private void fillStack1IfEmpty() {
    if (stack1.isEmpty()) {
      while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
      }
    }
  }

  public boolean empty() {
    fillStack1IfEmpty();
    return stack1.isEmpty();
  }
}
