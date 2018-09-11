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
public final class SolutionIII implements Solution {
  public List<Interval> merge(List<Interval> intervals) {
    final List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.isEmpty()) {
      return result;
    }

    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i, Interval j) {
        return Integer.compare(i.start, j.start);
      }
    });

    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); ++i) {
      final Interval prevInterval = result.get(result.size() - 1),
          curInterval = intervals.get(i);
      if (prevInterval.end >= curInterval.start) {
        prevInterval.end = Math.max(prevInterval.end, curInterval.end);
      } else {
        result.add(curInterval);
      }
    }
    return result;
  }
}
