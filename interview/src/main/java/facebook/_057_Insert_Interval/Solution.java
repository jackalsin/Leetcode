package facebook._057_Insert_Interval;

import definition.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    final List<Interval> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    // merge
    while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }
    result.add(newInterval);

    // add rest
    while (i < intervals.size()) {
      result.add(intervals.get(i));
      i++;
    }

    return result;
  }
}
