package linkedin._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/22/2019
 */
public final class NewSolutionII implements NewSolution {

  @Override
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(final int[] x, final int[] y) {
        return Integer.compare(x[0], y[0]);
      }
    });

    final List<int[]> result = new ArrayList<>();
    int[] cur = intervals[0];
    for (int i = 1; i < intervals.length; ++i) {
      if (cur[1] >= intervals[i][0]) {
        cur[1] = Math.max(intervals[i][1], cur[1]);
      } else { // need new cur
        result.add(cur);
        cur = intervals[i];
      }
    }
    result.add(cur);
    return result.toArray(new int[][]{});
  }
}
