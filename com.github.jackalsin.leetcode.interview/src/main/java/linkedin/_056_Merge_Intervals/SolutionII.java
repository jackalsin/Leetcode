package linkedin._056_Merge_Intervals;

import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionII implements Solution {
  public List<Interval> merge(List<Interval> intervals) {
    final List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) {
      return result;
    }
    Collections.sort(intervals, new Comparator<Interval>() {

      @Override
      public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
      }
    });
    result.add(intervals.get(0));

    for (int i = 1; i < intervals.size(); i++) {
      final Interval lastInterval = result.get(result.size() - 1), curInterval = intervals.get(i);
      if (lastInterval.end >= curInterval.start) {
        lastInterval.end = Math.max(lastInterval.end, curInterval.end);
      } else {
        result.add(curInterval);
      }
    }

    return result;
  }
}
