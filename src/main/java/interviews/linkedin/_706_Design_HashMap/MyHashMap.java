package interviews.linkedin._706_Design_HashMap;

import java.util.Arrays;

/**
 * 33 / 33 test cases passed.
 * Status: Accepted
 * Runtime: 110 ms
 */
public final class MyHashMap implements Solution {
  private static final int MAX = 1000000;
  private final int[] buckets = new int[MAX + 1];

  {
    Arrays.fill(buckets, -1);
  }

  public void put(int key, int value) {
    buckets[key] = value;
  }


  public int get(int key) {
    return buckets[key];
  }


  public int remove(int key) {
    buckets[key] = -1;
    return key;
  }
}
