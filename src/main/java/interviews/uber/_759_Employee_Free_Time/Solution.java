package interviews.uber._759_Employee_Free_Time;

import utils.Interval;

import java.util.*;

public class Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      /**
       * @param o1 [listIndex, elem index]
       * @param o2
       * @return
       */
      @Override
      public int compare(int[] o1, int[] o2) {
        final Interval i1 = schedule.get(o1[0]).get(o1[1]), i2 = schedule.get(o2[0]).get(o2[1]);
        return Integer.compare(i1.start, i2.start);
      }
    });
    final List<Interval> result = new ArrayList<>();
    for (int i = 0; i < schedule.size(); i++) {
      final List<Interval> s = schedule.get(i);
      if (!s.isEmpty()) {
        pq.add(new int[]{i, 0});
      }
    }

    Interval prev = new Interval(0, 1);
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final List<Interval> curList = schedule.get(toRemove[0]);
      final Interval curInterval = curList.get(toRemove[1]);
      if (prev.end >= curInterval.start) {
        prev.end = Math.max(prev.end, curInterval.end);
      } else {
        result.add(prev);
        prev = new Interval(curInterval.end, curInterval.end + 1);
      }
      if (toRemove[1] + 1 < curList.size()) {
        pq.add(new int[]{toRemove[0], toRemove[1] + 1});
      }
    }
    // todo: doubts
    if (result.size() > 0 && result.get(result.size() - 1).start != prev.start) {
      result.add(prev);
    }
    return result;
  }
}
