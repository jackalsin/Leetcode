package interviews.pinterest._056_Merge_Intervals;

import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.isEmpty()) {
      return new ArrayList<>();
    }
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        int cmp = Integer.compare(i1.start, i2.start);
        if (cmp == 0) {
          return Integer.compare(i1.end, i2.end);
        }
        return cmp;
      }
    });

    final List<Interval> result = new ArrayList<>();
    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      final Interval prev = result.get(result.size() - 1), cur = intervals.get(i);
      if (prev.end >= cur.start) {
        prev.end = Math.max(cur.end, prev.end);
      } else {
        result.add(cur);
      }
    }
    return result;
  }
}
