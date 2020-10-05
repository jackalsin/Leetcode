package _0601_0650._622_Design_Circular_Queue;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public final class MyCircularQueueI implements Solution {
  private final int capacity;
  private int start = 0, end = 0;
  private final int[] vals;

  public MyCircularQueueI(int k) {
    this.capacity = k;
    vals = new int[k];
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    vals[(end++) % capacity] = value;
//    System.out.println(toString());
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    ++start;
    pruneIndex();
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return vals[start];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return vals[(end - 1) % capacity];
  }

  public boolean isEmpty() {
    return start == end;
  }

  public boolean isFull() {
    return end - capacity == start;
  }

  private void pruneIndex() {
    if (start >= capacity) {
      start -= capacity;
      end -= capacity;
    }
  }

  @Override
  public String toString() {
    return "MyCircularQueue{" +
        "capacity=" + capacity +
        ", values=" + Arrays.toString(vals) +
        ", start=" + start +
        ", end=" + end +
        '}';
  }
}
