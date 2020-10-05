package facebook._253_Meeting_Rooms_I;

import definition.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class PqSolution implements Solution {

  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, new Comparator<Interval>() {

      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });

    final PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.end, i2.end);
      }
    });

    int max = 1;

    for (int i = 0; i < intervals.length; i++) {
      // earliest finish
      final Interval interval = intervals[i];
      // remove already ended
      while (!pq.isEmpty() && pq.peek().end <= interval.start) {
        pq.remove();
      }
      pq.add(interval);
      max = Math.max(max, pq.size());
    }

    return max;
  }

}
