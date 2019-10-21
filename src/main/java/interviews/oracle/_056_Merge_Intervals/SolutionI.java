package interviews.oracle._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] merge(int[][] intervals) {
    final List<int[]> result = new ArrayList<>();
    if (intervals == null || intervals.length == 0) {
      return result.toArray(new int[][]{});
    }
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });
    int[] prev = intervals[0];
    for (int i = 1; i < intervals.length; ++i) {
      final int[] cur = intervals[i];
      if (prev[1] >= cur[0]) {
        prev[1] = Math.max(prev[1], cur[1]);
      } else {
        result.add(new int[]{prev[0], prev[1]});
        prev = cur;
      }
    }
    result.add(prev);
    return result.toArray(new int[][]{});
  }
}
