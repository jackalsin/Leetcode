package _0601_0650._622_Design_Circular_Queue;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public final class MyCircularQueue implements Solution {
  private final int capacity;
  private final int[] values;
  private int start = 0, end = -1, size = 0;

  public MyCircularQueue(int k) {
    this.capacity = k;
    values = new int[k];
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    end = (end + 1) % capacity;
    values[end] = value;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (size == 0) {
      return false;
    }
    start = (start + 1) % capacity;
    size--;
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return values[start];
  }

  public int Rear() {
    if (size == 0) {
      return -1;
    }
    return values[end];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  @Override
  public String toString() {
    return "MyCircularQueue{" +
        "capacity=" + capacity +
        ", values=" + Arrays.toString(values) +
        ", start=" + start +
        ", end=" + end +
        ", size=" + size +
        '}';
  }
}
