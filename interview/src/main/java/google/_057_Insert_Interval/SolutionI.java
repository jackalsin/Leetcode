package google._057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null) {
      return new int[][]{newInterval};
    }
    Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
    final List<int[]> result = new ArrayList<>();
    int i = 0;
    for (; i < intervals.length; ++i) {
      if (intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
      } else {
        break;
      }
    }
    for (; i < intervals.length; ++i) {
      if (intervals[i][0] > newInterval[1]) break;
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    }
    result.add(newInterval);
    for (; i < intervals.length; ++i) {
      result.add(intervals[i]);
    }
    return result.toArray(new int[][]{});
  }
}
