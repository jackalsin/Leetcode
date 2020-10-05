package facebook._056_Merge_Intervals;

import definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    final List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.isEmpty()) {
      return result;
    }
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });
    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      final Interval curInterval = intervals.get(i),
          lastInterval = result.get(result.size() - 1);
      if (curInterval.start <= lastInterval.end) { // merge
        lastInterval.end = Math.max(lastInterval.end, curInterval.end);
      } else {
        result.add(curInterval);
      }
    }
    return result;
  }
}
