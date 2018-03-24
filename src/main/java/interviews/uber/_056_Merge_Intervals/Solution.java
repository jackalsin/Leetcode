package interviews.uber._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import utils.Interval;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution { // TODO：
  public List<Interval> merge(List<Interval> intervals) {
    intervals.sort(new Comparator<>() {

      /**
       * Time Complexity: O (N^2)
       * @param o1
       * @param o2
       * @return
       */
      @Override
      public int compare(Interval o1, Interval o2) {
        int cmp = Integer.compare(o1.start, o2.start);
        if (cmp == 0) {
          return Integer.compare(o2.end, o1.end);
        }
        return cmp;
      }
    });
    final List<Interval> result = new ArrayList<>();
    if (intervals.size() == 0) {
      return result;
    }
    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      if (intervals.get(i).start <= result.get(result.size() - 1).end) {
        final int lastIndex = result.size() - 1;
        int lastEnd = Math.max(intervals.get(i).end, result.get(lastIndex).end);
        result.get(result.size() - 1).end = lastEnd;
      } else {
        result.add(intervals.get(i));
      }
    }
    return result;
  }
}
