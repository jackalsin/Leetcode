package _0601_0650._622_Design_Circular_Queue;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public interface Solution {
  /**
   * Insert an element into the circular queue. Return true if the operation is successful.
   */
  boolean enQueue(int value);

  /**
   * Delete an element from the circular queue. Return true if the operation is successful.
   */
  boolean deQueue();

  /**
   * Get the front item from the queue.
   */
  int Front();

  /**
   * Get the last item from the queue.
   */
  int Rear();

  /**
   * Checks whether the circular queue is empty or not.
   */
  boolean isEmpty();

  /**
   * Checks whether the circular queue is full or not.
   */
  boolean isFull();
}
