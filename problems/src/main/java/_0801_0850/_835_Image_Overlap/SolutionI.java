package _0801_0850._835_Image_Overlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int largestOverlap(int[][] A, int[][] B) {
    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return 0;
    }
    final List<Integer> normalizedA = getNormalized(A),
        normalizedB = getNormalized(B);
    final Map<Integer, Integer> diff = new HashMap<>();
    int max = 0;
    for (int i : normalizedA) {
      for (int j : normalizedB) {
        final int cur = diff.getOrDefault(i - j, 0) + 1;
        max = Math.max(cur, max);
        diff.put(i - j, cur);
      }
    }
    return max;
  }

  /**
   * Return a list of coordinate that
   */
  private static List<Integer> getNormalized(final int[][] matrix) {
    final int N = matrix.length;
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (matrix[i][j] == 1) {
          result.add(i * 100 + j);
        }
      }
    }
    return result;
  }
}
