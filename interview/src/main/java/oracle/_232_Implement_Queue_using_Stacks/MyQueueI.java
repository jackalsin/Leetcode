package oracle._232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/15/2019
 */
public final class MyQueueI implements MyQueue {
  private final Deque<Integer> pushStack = new ArrayDeque<>(),
      popStack = new ArrayDeque<>();

  public void push(int x) {
    pushStack.push(x);
  }


  public int pop() {
    prune();
    return popStack.pop();
  }


  public int peek() {
    prune();
    return popStack.peek();
  }

  private void prune() {
    if (popStack.isEmpty()) {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
    }
  }

  public boolean empty() {
    return pushStack.isEmpty() && popStack.isEmpty();
  }
}
