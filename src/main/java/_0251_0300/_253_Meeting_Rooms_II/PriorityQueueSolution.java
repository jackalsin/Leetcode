package _0251_0300._253_Meeting_Rooms_II;

import utils.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public final class PriorityQueueSolution {

  public int minMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {

      @Override
      public int compare(Interval o1, Interval o2) {
        final int cmp = Integer.compare(o1.start, o2.start);
        if (cmp == 0) {
          return Integer.compare(o1.end, o2.end);
        }
        return cmp;
      }
    });
    int maxRoom = 0;
    final Queue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.end, o2.end);
      }
    });
    for (Interval i : intervals) {
      while (!pq.isEmpty() && pq.peek().end <= i.start) {
        pq.remove();
      }
      pq.add(i);
      maxRoom = Math.max(maxRoom, pq.size());
    }
    return maxRoom;
  }
}
