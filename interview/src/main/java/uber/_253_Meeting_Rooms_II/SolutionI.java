package uber._253_Meeting_Rooms_II;

import definition.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class SolutionI implements Solution { // TODO: untested
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
    final Queue<Integer> pq = new PriorityQueue<>(
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
          }
        }
    );
    int min = 1;
    pq.add(intervals[0].end);
    for (int i = 1; i < intervals.length; i++) {
      if (!pq.isEmpty() && intervals[i].start >= pq.peek()) {
        pq.remove();
      }

      pq.add(intervals[i].end);
      min = Math.max(min, pq.size());
    }
    return min;
  } // end of method
}
