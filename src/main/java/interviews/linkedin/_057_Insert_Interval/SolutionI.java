package interviews.linkedin._057_Insert_Interval;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public final class SolutionI implements Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
      result.add(intervals.get(i++));
    }
    // curInterval.end >= newInterval.start;
    if (i < intervals.size()) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
    }
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.end = Math.max(intervals.get(i++).end, newInterval.end);
    }
    result.add(newInterval);
    while (i < intervals.size()) {
      result.add(intervals.get(i++));
    }
    return result;
  }
}
