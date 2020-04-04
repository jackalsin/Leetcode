package interviews.google._056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[][]{};
    }
    Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

    final List<int[]> result = new ArrayList<>();
    int start = intervals[0][0], end = intervals[0][1];
    for (int i = 1; i < intervals.length; ++i) {
      final int curStart = intervals[i][0],
          curEnd = intervals[i][1];
      if (curStart <= end) {
        end = Math.max(curEnd, end);
      } else {
        result.add(new int[]{start, end});
        start = curStart;
        end = curEnd;
      }
    }
    result.add(new int[]{start, end});
    return transform(result);
  }

  private static int[][] transform(final List<int[]> source) {
    final int[][] res = new int[source.size()][2];
    for (int i = 0; i < source.size(); ++i) {
      res[i][0] = source.get(i)[0];
      res[i][1] = source.get(i)[1];
    }
    return res;
  }
}
