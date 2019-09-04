package interviews.linkedin._362_Design_Hit_Counter;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class HitCounterII implements HitCounter {
  private final Queue<Integer> q = new ArrayDeque<>();

  public void hit(int timestamp) {
    q.add(timestamp);
    while (q.peek() <= timestamp - 300) {
      q.remove();
    }
  }

  public int getHits(int timestamp) {
    while (!q.isEmpty() && q.peek() <= timestamp - 300) {
      q.remove();
    }
    return q.size();
  }
}
