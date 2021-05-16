package uber._986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    final List<int[]> result = new ArrayList<>();
    for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
      final int firstEnd = firstList[i][1], secondEnd = secondList[j][1];
      final int maxStart = Math.max(firstList[i][0], secondList[j][0]),
          minEnd = Math.min(firstEnd, secondEnd);
      if (maxStart <= minEnd) {
        result.add(new int[]{maxStart, minEnd});
      }

      if (firstEnd < secondEnd) {
        ++i;
      } else if (firstEnd > secondEnd) {
        ++j;
      } else {
        ++i;
        ++j;
      }
    }
    return result.toArray(new int[][]{});
  }
}
