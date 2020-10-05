package _0351_0400._362_Design_Hit_Counter;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 24 / 24 test cases passed.
 * Status: Accepted
 * Runtime: 91 ms
 *
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class HitCounter {
  private final Queue<Integer> hitsPq;

  /**
   * Initialize your data structure here.
   */
  public HitCounter() {
    hitsPq = new ArrayDeque<>();
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    evictOlderThan300(timestamp);
    hitsPq.add(timestamp);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    evictOlderThan300(timestamp);
    return hitsPq.size();
  }

  private void evictOlderThan300(final int timestamp) {
    while (!hitsPq.isEmpty() && hitsPq.peek() <= timestamp - 300) {
      hitsPq.remove();
    }
  }
}
