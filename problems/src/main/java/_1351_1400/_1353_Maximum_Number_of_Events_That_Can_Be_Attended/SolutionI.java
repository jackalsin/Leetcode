package _1351_1400._1353_Maximum_Number_of_Events_That_Can_Be_Attended;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public final class SolutionI implements Solution {
  public int maxEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
    int res = 0, i = 0;
    final int n = events.length;
    final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    for (int d = 1; d <= 100_000; d++) {
      while (i < n && events[i][0] == d) {
        pq.add(events[i++]);
      }
      while (!pq.isEmpty() && pq.peek()[1] < d) {
        pq.remove();
      }
      if (pq.size() > 0) {
        pq.remove();
        res++;
      }
    }
    return res;
  }
}
