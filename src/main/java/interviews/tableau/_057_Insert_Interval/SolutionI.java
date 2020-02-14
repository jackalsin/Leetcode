package interviews.tableau._057_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int i = 0;
    final List<int[]> result = new ArrayList<>();
    for (; i < intervals.length; ++i) {
      if (newInterval[0] <= intervals[i][1]) {
        break;
      }
      result.add(intervals[i]);
    }

    final int[] toInsert = {newInterval[0], newInterval[1]};
    while (i < intervals.length) {
      if (toInsert[1] < intervals[i][0]) break;
      toInsert[0] = Math.min(toInsert[0], intervals[i][0]);
      toInsert[1] = Math.max(toInsert[1], intervals[i][1]);
      i++;
    }
    result.add(toInsert);
    for (; i < intervals.length; ++i) {
      result.add(intervals[i]);
    }
//    display(result.toArray(new int[][]{}));
    return result.toArray(new int[][]{});
  }
}
