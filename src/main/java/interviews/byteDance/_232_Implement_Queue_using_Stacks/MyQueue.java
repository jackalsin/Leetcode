package interviews.byteDance._232_Implement_Queue_using_Stacks;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public interface MyQueue {

  /**
   * Push element x to the back of queue.
   */
  void push(int x);

  /**
   * Removes the element from in front of queue and returns that element.
   */
  int pop();

  /**
   * Get the front element.
   */
  int peek();

  /**
   * Returns whether the queue is empty.
   */
  boolean empty();
}
