package microsoft._056_Merge_Intervals;

import definition.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    final List<Interval> result = new ArrayList<>();

    if (intervals.isEmpty()) {
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
      final Interval prevInterval = result.get(result.size() - 1), curInterval = intervals.get(i);
      if (prevInterval.end < curInterval.start) {
        result.add(curInterval);
      } else {
        prevInterval.end = Math.max(prevInterval.end, curInterval.end);
      }
    }
    return result;
  }
}
