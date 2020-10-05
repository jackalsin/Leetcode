package uber._056_Merge_Intervals;

import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) {
      return new ArrayList<>();
    }

    final List<Interval> result = new ArrayList<>();
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(final Interval i1, final Interval i2) {
        int cmp = Integer.compare(i1.start, i2.start);
        if (cmp == 0) {
          return Integer.compare(i1.end, i2.end);
        }
        return cmp;
      }
    });
    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      final Interval curInterval = intervals.get(i), prevInterval = result.get(result.size() - 1);
      if (curInterval.start <= prevInterval.end) {
        prevInterval.end = Math.max(curInterval.end, prevInterval.end);
      } else {
        result.add(curInterval);
      }
    }
    return result;
  }
}
