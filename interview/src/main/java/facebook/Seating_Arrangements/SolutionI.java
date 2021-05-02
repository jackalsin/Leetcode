package facebook.Seating_Arrangements;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int minOverallAwkwardness(int[] arr) {
    int max = 0;
    final Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    for (int a : arr) {
      pq.add(a);
    }
    int left = pq.peek(), right = pq.remove();
    while (!pq.isEmpty()) {
      final int l = pq.remove();
      if (pq.isEmpty()) {
        max = Math.max(max, left - l);
        max = Math.max(max, right - l);
      } else {
        max = Math.max(max, left - l);
        final int r = pq.remove();
        max = Math.max(max, right - r);
        left = l;
        right = r;
      }
    }
    return max;
  }
}
