package _0251_0300._253_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public final class PriorityQueueSolution implements Solution {

  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      final int cmp = Integer.compare(a[0], b[0]);
      if (cmp != 0) {
        return cmp;
      }
      return Integer.compare(a[1], b[1]);
    });
    int maxRoom = 0;
    final Queue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
    for (final int[] interval : intervals) {
      while (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
        pq.remove();
      }
      pq.add(interval);
      maxRoom = Math.max(maxRoom, pq.size());
    }
    return maxRoom;
  }
}
