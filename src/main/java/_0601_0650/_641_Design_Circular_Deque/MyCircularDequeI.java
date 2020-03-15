package _0601_0650._641_Design_Circular_Deque;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class MyCircularDequeI implements MyCircularDeque {
  private final int size;
  private final int[] vals;
  // both inclusive
  private int start = 1, end = 0, count = 0;

  public MyCircularDequeI(final int size) {
    this.size = size;
    vals = new int[size];
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    ++count;
    --start;
    pruneIndex();
    vals[start] = value;
    return true;
  }

  private void pruneIndex() {
    if (start < 0) {
      start += size;
    }
    if (start >= size) {
      start -= size;
    }
    if (end >= size) {
      end -= size;
    }
    if (end < 0) {
      end += size;
    }
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    ++end;
    count++;
    pruneIndex();
    vals[end] = value;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    count--;
    start++;
    pruneIndex();
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    count--;
    end--;
    pruneIndex();
    return true;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return vals[start];
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return vals[end];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == size;
  }
}
