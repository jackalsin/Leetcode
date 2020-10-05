package linkedin._362_Design_Hit_Counter;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class HitCounterI implements HitCounter {
  private final Queue<Integer> q = new ArrayDeque<>();
  private static final int PAST = 300;

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    prune(timestamp);
    q.add(timestamp);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    prune(timestamp);
    return q.size();
  }

  private void prune(final int timestamp) {
    while (!q.isEmpty() && q.peek() <= timestamp - PAST) {
      q.remove();
    }
  }
}
