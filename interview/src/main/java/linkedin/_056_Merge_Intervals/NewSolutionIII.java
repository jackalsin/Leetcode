package linkedin._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class NewSolutionIII implements NewSolution {

  @Override
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return intervals;
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    final List<int[]> result = new ArrayList<>();
    int[] prev = intervals[0];
    for (int i = 1; i < intervals.length; ++i) {
      final int[] cur = intervals[i];
      if (prev[1] >= cur[0]) {
        prev[1] = Math.max(cur[1], prev[1]);
        prev[0] = Math.min(cur[0], prev[0]);
      } else {
        result.add(prev);
        prev = cur;
      }
    }
    result.add(prev);

    return result.toArray(int[][]::new);
  }
}
