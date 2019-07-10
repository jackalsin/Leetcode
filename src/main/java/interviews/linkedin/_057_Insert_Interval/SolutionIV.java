package interviews.linkedin._057_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/9/2019
 */
public final class SolutionIV implements April152019Solution {

  @Override
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || newInterval == null) {
      return intervals;
    }
    final List<int[]> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i++]);
    }

    while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    result.add(newInterval);
    while (i < intervals.length) {
      result.add(intervals[i++]);
    }
    return result.toArray(new int[][]{});
  }
}
