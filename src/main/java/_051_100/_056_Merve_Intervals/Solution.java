package _051_100._056_Merve_Intervals;

import java.util.ArrayList;
import java.util.List;

import utils.Interval;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.isEmpty()) return result;

    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

    for (Interval interval: intervals) {
      if (result.isEmpty()) {
        result.add(interval);
      } else if (interval.start <= result.get(result.size() - 1).end) {
        Interval prevInterval = result.get(result.size() - 1);
        prevInterval.end = prevInterval.end > interval.end ? prevInterval.end:interval.end;
      } else {
        result.add(interval);
      }
    }
    return result;
  }
}
