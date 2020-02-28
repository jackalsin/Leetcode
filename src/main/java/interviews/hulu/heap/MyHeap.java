package interviews.hulu.heap;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/16/2019
 */
public final class MyHeap {
  private int size = 0, capacity = 5;

  private int[] vals = new int[capacity];

  public void add(final int e) {
    ensureExtraCapacity();
    vals[size] = e;
    size++;

    shiftUp();
  }

  public int remove() {
    int minItem = vals[0];
    vals[0] = vals[size - 1];
    size--;
    shiftDown();
    return minItem;
  }

  private void shiftUp() {
    int index = size - 1;
    while (hasParentIndex(index) && vals[getParentIndex(index)] >= vals[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  private void shiftDown() {
    int parentIndex = 0;
    while (hasLeftChild(parentIndex)) {
      int smallChildIndex = getLeftChildIndex(parentIndex);
      if (hasRightChild(parentIndex) && vals[getRightChildIndex(parentIndex)] < vals[smallChildIndex]) {
        smallChildIndex = getRightChildIndex(parentIndex);
      }

      if (vals[parentIndex] < vals[smallChildIndex]) {
        break;
      } else {
        swap(parentIndex, smallChildIndex);
      }
      parentIndex = smallChildIndex;
    }
  }

  private boolean hasLeftChild(final int parentIndex) {
    return 2 * parentIndex + 1 < size;
  }

  private boolean hasRightChild(final int parentIndex) {
    return 2 * parentIndex + 2 < size;
  }

  private boolean hasParentIndex(final int c) {
    return c != 0;
  }

  private static int getParentIndex(final int c) {
    return (c - 1) / 2;
  }

  private static int getLeftChildIndex(final int p) {
    return 2 * p + 1;
  }

  private static int getRightChildIndex(final int p) {
    return 2 * p + 2;
  }

  private void ensureExtraCapacity() {
    if (size == vals.length) {
      vals = Arrays.copyOf(vals, capacity * 2);
      capacity *= 2;
    }
  }

  private void swap(int i, int j) {
    final int temp = vals[i];
    vals[i] = vals[j];
    vals[j] = temp;
  }
}
