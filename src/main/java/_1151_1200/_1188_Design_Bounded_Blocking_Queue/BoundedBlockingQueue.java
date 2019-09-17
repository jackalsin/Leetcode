package _1151_1200._1188_Design_Bounded_Blocking_Queue;

/**
 * @author jacka
 * @version 1.0 on 9/16/2019
 */
public interface BoundedBlockingQueue {

  void enqueue(int element) throws InterruptedException;

  int dequeue() throws InterruptedException;

  int size();
}
