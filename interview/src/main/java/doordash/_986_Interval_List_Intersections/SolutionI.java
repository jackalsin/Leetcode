package doordash._986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    final List<int[]> result = new ArrayList<>();
    if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0)
      return result.toArray(int[][]::new);
    final int m = firstList.length, n = secondList.length;
    for (int i = 0, j = 0; i < m && j < n; ) {
      final int[] first = firstList[i], second = secondList[j];
      if (first[1] < second[0]) {
        ++i;
      } else if (second[1] < first[0]) {
        ++j;
      } else {
        final int start = Math.max(first[0], second[0]),
            end = Math.min(first[1], second[1]);
        result.add(new int[]{start, end});
        if (first[1] < second[1]) {
          ++i;
        } else {
          ++j;
        }
      }
    }
    return result.toArray(int[][]::new);
  }
}
