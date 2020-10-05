package _0951_1000._986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/23/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    final List<int[]> result = new ArrayList<>();
    if (A == null || B == null || A.length == 0 || B.length == 0) {
      return result.toArray(new int[][]{});
    }
    for (int i = 0, j = 0; i < A.length && j < B.length; ) {
      final int[] a = A[i], b = B[j];
      if (b[0] > a[1]) {
        ++i;
      } else if (b[0] <= a[1] && a[1] <= b[1]) {
        result.add(new int[]{Math.max(a[0], b[0]), a[1]});
        i++;
      } else if (a[1] > b[1] && a[0] <= b[0]) {
        result.add(new int[]{b[0], b[1]});
        ++j;
      } else if (a[1] > b[1] && a[0] > b[1]) {
        ++j;
      } else if (a[1] > b[1] && a[0] > b[0] && a[0] <= b[1]) {
        result.add(new int[]{a[0], b[1]});
        ++j;
      } else {
        throw new IllegalStateException("Never");
      }
    }
    return result.toArray(new int[][]{});
  }
}
