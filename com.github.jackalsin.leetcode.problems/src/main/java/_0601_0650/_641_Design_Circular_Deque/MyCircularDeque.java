package _0601_0650._641_Design_Circular_Deque;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public interface MyCircularDeque {
  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  boolean insertFront(int value);

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  boolean insertLast(int value);

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  boolean deleteFront();

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  boolean deleteLast();

  /**
   * Get the front item from the deque.
   */
  int getFront();

  /**
   * Get the last item from the deque.
   */
  int getRear();

  /**
   * Checks whether the circular deque is empty or not.
   */
  boolean isEmpty();

  /**
   * Checks whether the circular deque is full or not.
   */
  boolean isFull();

}
