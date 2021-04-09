package lime._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/9/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    final List<int[]> result = new ArrayList<>();
    Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
    int[] prev = intervals[0];
    final int n = intervals.length;
    for (int i = 1; i < n; ++i) {
      final int[] cur = intervals[i];
      if (prev[1] >= cur[0]) {
        prev[1] = Math.max(cur[1], prev[1]);
      } else {
        result.add(prev);
        prev = cur;
      }
    }
    result.add(prev);
    return result.toArray(new int[][]{});
  }
}
