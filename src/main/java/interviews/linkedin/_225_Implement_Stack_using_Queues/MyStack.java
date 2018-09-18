package interviews.linkedin._225_Implement_Stack_using_Queues;

public interface MyStack {

  /**
   * Push element x onto stack.
   */
  void push(int x);

  /**
   * Removes the element on top of the stack and returns that element.
   */
  int pop();

  /**
   * Get the top element.
   */
  int top();

  /**
   * Returns whether the stack is empty.
   */
  boolean empty();
}
