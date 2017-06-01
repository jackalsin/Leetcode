package _051_100._057_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

import utils.Interval;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class Solution {
  /**
   *
   * @param intervals   sorted by start times
   * @param newInterval
   * @return
   */
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    return insertNoCreation(intervals, newInterval);
//    return insertCreation(intervals, newInterval);
  }

  private List<Interval> insertNoCreation(List<Interval> intervals, Interval newInterval) {
    if (intervals == null) {
      return new ArrayList<>();
    }
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
    while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      intervals.remove(i);
    }
    intervals.add(i, newInterval);
    return intervals;
  }

  private List<Interval> insertCreation(List<Interval> intervals, Interval newInterval) {
    if (intervals == null) {
      return new ArrayList<>();
    }

    List<Interval> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i++));
    }
    while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }
    result.add(newInterval);
    while (i < intervals.size()) {
      result.add(intervals.get(i++));
    }
    return result;
  }

}
