package interviews.linkedin._057_Insert_Interval;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionII implements Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();
    int i = 0;

    // add lower
    while (i < intervals.size() && intervals.get(i).start <= newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    if (result.size() > 0) {
      final Interval lastInterval = result.get(result.size() - 1);
      if (lastInterval.end >= newInterval.start) {
        lastInterval.end = Math.max(lastInterval.end, newInterval.end);
      } else {
        result.add(newInterval);
      }
    } else {
      result.add(newInterval);
    }

    while (i < intervals.size()) {
      final Interval lastInterval = result.get(result.size() - 1), curInterval = intervals.get(i);
      if (lastInterval.end >= curInterval.start) {
        lastInterval.end = Math.max(curInterval.end, lastInterval.end);
      } else {
        result.add(intervals.get(i));
      }
      i++;
    }
    return result;
  }
}
