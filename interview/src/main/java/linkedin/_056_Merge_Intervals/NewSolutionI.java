package linkedin._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 6/27/2019
 */
public final class NewSolutionI implements NewSolution {

  @Override
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }

    final List<int[]> result = new ArrayList<>();
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });

    int[] cur = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (cur[1] >= intervals[i][0]) {
        cur[1] = Math.max(cur[1], intervals[i][1]);
      } else {
        result.add(cur);
        cur = intervals[i];
      }
    }
    result.add(cur);
    return result.toArray(new int[0][]);
  }
}
