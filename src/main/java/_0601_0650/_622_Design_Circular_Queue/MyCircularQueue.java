package _0601_0650._622_Design_Circular_Queue;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public final class MyCircularQueue implements Solution {
  private final int k;
  private final int[] values;
  private int start = 0, end = 0;

  public MyCircularQueue(int k) {
    this.k = k;
    values = new int[k];
  }

  public boolean enQueue(int value) {
    if (end == start + k || k == 0) {
      return false;
    }
    values[end % k] = value;
    ++end;
    return true;
  }

  public boolean deQueue() {
    if (start == end || k == 0) {
      return false;
    }
    ++start;
    pruneIndex();
    return true;
  }

  public int Front() {
    if (end <= start) {
      return -1;
    }
    return values[start % k];
  }

  public int Rear() {
    if (end <= start) {
      return -1;
    }
    return values[(end - 1 + k) % k];
  }

  public boolean isEmpty() {
    return start == end;
  }

  public boolean isFull() {
    return start + k == end;
  }

  private void pruneIndex() {
    if (start >= k) {
      start -= k;
      end -= k;
    }
  }
}
