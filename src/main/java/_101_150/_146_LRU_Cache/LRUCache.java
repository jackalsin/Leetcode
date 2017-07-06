package _101_150._146_LRU_Cache;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class LRUCache {
  private static final int INVALID = -1;

  private final int capacity;

  private final int[] keyToValue;

  private final Queue<Integer> queue;

  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be greater than 0, but now is " + capacity);
    }
    this.capacity = capacity;
    keyToValue = new int[capacity + 1];
    Arrays.fill(keyToValue, INVALID);
    queue = new ArrayDeque<>();
  }

  public int get(int key) {
    return keyToValue[key];
  }

  public void put(int key, int value) {
    if (queue.size() == capacity) {
      Integer evictKey = queue.poll();
      keyToValue[evictKey] = INVALID;
      queue.offer(key);
    }
    keyToValue[key] = value;
  }
}
