package interviews.linkedin._057_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/22/2019
 */
public final class SolutionV implements April152019Solution {
  @Override
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0) {
      return new int[][]{newInterval};
    }
    final List<int[]> result = new ArrayList<>();
    int i = 0;
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      i++;
    }

    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }
    result.add(newInterval);
    while (i < intervals.length) {
      result.add(intervals[i]);
      ++i;
    }
    return result.toArray(new int[][]{});
  }
}
