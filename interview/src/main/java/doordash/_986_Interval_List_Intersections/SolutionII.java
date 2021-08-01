package doordash._986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {
  @Override
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    final List<int[]> result = new ArrayList<>();
    for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
      final int[] left = firstList[i], right = secondList[j];
      final int start = Math.max(left[0], right[0]), end = Math.min(left[1], right[1]);
      if (start <= end) result.add(new int[]{start, end});
      if (left[1] < right[1]) {
        ++i;
      } else if (left[1] > right[1]) {
        ++j;
      } else {
        ++i;
        ++j;
      }
    }
    return result.toArray(new int[][]{});
  }
}
