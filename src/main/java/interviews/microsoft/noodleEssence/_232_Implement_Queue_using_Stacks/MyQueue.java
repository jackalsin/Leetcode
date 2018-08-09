package interviews.microsoft.noodleEssence._232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public final class MyQueue {
  private final Deque<Integer> popStack = new ArrayDeque<>(),
      pushStack = new ArrayDeque<>();

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    pushStack.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    if (popStack.isEmpty()) { // push to push
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
    }
    return popStack.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    if (popStack.isEmpty()) { // push to push
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
    }
    assert !popStack.isEmpty();
    return popStack.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return pushStack.isEmpty() && popStack.isEmpty();
  }
}
