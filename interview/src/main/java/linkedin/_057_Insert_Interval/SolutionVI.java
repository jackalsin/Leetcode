package linkedin._057_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionVI implements April152019Solution {
  @Override
  public int[][] insert(int[][] intervals, int[] newInterval) {
    final List<int[]> result = new ArrayList<>();
    final int n = intervals.length;
    int i = 0;
    while (i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      ++i;
    }
    final int[] curInterval = new int[]{newInterval[0], newInterval[1]};
    while (i < n && curInterval[1] >= intervals[i][0]) {
      curInterval[0] = Math.min(curInterval[0], intervals[i][0]);
      curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
      ++i;
    }

    result.add(curInterval);
    while (i < n) {
      result.add(intervals[i]);
      ++i;
    }

    return result.toArray(int[][]::new);
  }
}
