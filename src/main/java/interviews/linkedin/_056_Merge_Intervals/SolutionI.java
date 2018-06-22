package interviews.linkedin._056_Merge_Intervals;

import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionI implements Solution {
  public List<Interval> merge(List<Interval> intervals) {
    final List<Interval> result = new ArrayList<>();
    if (intervals.size() == 0) {
      return result;
    }
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });
    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); ++i) {
      final Interval curInterval = intervals.get(i), prevInterval = result.get(result.size() - 1);
      if (prevInterval.end >= curInterval.start) {
        prevInterval.end = Math.max(curInterval.end, prevInterval.end);
      } else {
        result.add(curInterval);
      }
    }
    return result;
  }
}
