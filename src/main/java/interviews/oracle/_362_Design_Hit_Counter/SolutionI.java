package interviews.oracle._362_Design_Hit_Counter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 300;
  private final Deque<Integer> q = new ArrayDeque<>();

  public void hit(int timestamp) {
    prune(timestamp);
    q.add(timestamp);
  }

  public int getHits(int timestamp) {
    prune(timestamp);
    return q.size();
  }

  private void prune(final int timestamp) {
    while (!q.isEmpty() && timestamp - N >= q.peek()) {
      q.remove();
    }
  }
}
