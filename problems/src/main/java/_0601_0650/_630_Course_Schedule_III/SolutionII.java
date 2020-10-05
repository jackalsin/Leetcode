package _0601_0650._630_Course_Schedule_III;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/7/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
    final Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    int d = 0;
    for (final int[] c : courses) {
      final int t = c[0], end = c[1];
      d += t;
      pq.add(t);
      if (d > end) {
        d -= pq.remove();
      }
    }
    return pq.size();
  }
}
