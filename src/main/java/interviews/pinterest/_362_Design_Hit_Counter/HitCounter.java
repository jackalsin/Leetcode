package interviews.pinterest._362_Design_Hit_Counter;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 24 / 24 test cases passed.
 * Status: Accepted
 * Runtime: 102 ms
 */
public final class HitCounter {
  private final Queue<Integer> inPast300Seconds = new ArrayDeque<>();

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    remove300SecondsBeforeOrEquals(timestamp);
    inPast300Seconds.add(timestamp);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    remove300SecondsBeforeOrEquals(timestamp);
    return inPast300Seconds.size();
  }

  private void remove300SecondsBeforeOrEquals(int timestamp) {
    while (!inPast300Seconds.isEmpty() && inPast300Seconds.peek() <= timestamp - 300) {
      inPast300Seconds.remove();
    }
  }
}
