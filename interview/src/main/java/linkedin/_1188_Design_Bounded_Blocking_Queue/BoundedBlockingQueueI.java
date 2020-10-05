package linkedin._1188_Design_Bounded_Blocking_Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public final class BoundedBlockingQueueI implements BoundedBlockingQueue {
  private final int capacity;
  private final Queue<Integer> q = new ArrayDeque<>();

  public BoundedBlockingQueueI(int capacity) {
    this.capacity = capacity;
  }

  public void enqueue(int element) throws InterruptedException {
    synchronized (q) {
      while (q.size() >= capacity) {
        q.wait();
      }
      q.add(element);
      q.notifyAll();
    }
  }

  public int dequeue() throws InterruptedException {
    synchronized (q) {
      while (q.isEmpty()) {
        q.wait();
      }
      final int res = q.remove();
      q.notifyAll();
      return res;
    }
  }

  public int size() {
    synchronized (q) {
      return q.size();
    }
  }
}
