package _101_150._146_LRU_Cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class LRUCache {
  private static final int INVALID = -1;

  private final int capacity;

  private final Map<Integer, Integer> keyToValue;

  private final Queue<KeyCount> pq;
  private static int count;

  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be greater than 0, but now is " + capacity);
    }
    count = 0;
    this.capacity = capacity;
    keyToValue = new HashMap<>();
    pq = new PriorityQueue<>(new Comparator<KeyCount>() {
      @Override
      public int compare(KeyCount o1, KeyCount o2) {
        return Integer.compare(o1.count, o2.count);
      }
    });
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      int result = keyToValue.get(key);




      return result;
    } else {
      return INVALID;
    }
  }

  public void put(int key, int value) {
//    if (keyUsed.size() == capacity) {
//      Integer evictKey = keyUsed.;
//      keyToValue.remove(evictKey);
//      queue.offer(key);
//    }
    keyToValue.put(key, value);
  }

  private static final class KeyCount {
    final int key;
    int count;

    KeyCount(int k, int count) {
      key = k;
      this.count = count;
    }

    @Override
    public String toString() {
      return "(" + key + ", " + count + ")";
    }
  }


  public static void main(String[] args) {
    Map<Integer, Integer> map = new LinkedHashMap<>(5, 0.75f, true);
    for (int i = 0; i < 5; i++) {
      map.put(i, i);
    }

    map.get(3);
    map.put(2, 2);
    map.getOrDefault(1, 3);
    map.containsKey(0);
    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
      System.out.println(integerIntegerEntry);
    }
  }
}
