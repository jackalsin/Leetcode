package _0201_0250._225_Implement_Stack_using_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
public class MyStack {
  private Deque<Integer> queue;
  /** Initialize your data structure here. */
  public MyStack() {
    queue = new ArrayDeque<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.addLast(x);
    for(int i = 0; i < queue.size() - 1; i++) {
      queue.addLast(queue.peekFirst());
      queue.removeFirst();
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.removeFirst();
  }

  /** Get the top element. */
  public int top() {
    return queue.peekFirst();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}
