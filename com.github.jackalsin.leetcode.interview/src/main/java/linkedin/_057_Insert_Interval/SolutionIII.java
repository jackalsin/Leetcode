package linkedin._057_Insert_Interval;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionIII implements Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    final List<Interval> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      final Interval inter = intervals.get(i);
      newInterval.start = Math.min(newInterval.start, inter.start);
      newInterval.end = Math.max(newInterval.end, inter.end);
      i++;
    }

    result.add(newInterval);

    while (i < intervals.size()) {
      result.add(intervals.get(i));
      i++;
    }
    return result;
  }
}
