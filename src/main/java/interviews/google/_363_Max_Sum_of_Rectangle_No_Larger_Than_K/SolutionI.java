package interviews.google._363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 4/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    int max = Integer.MIN_VALUE;
    for (int up = 0; up < rows; ++up) {
      final int[] accumulatedSum = new int[cols];
      for (int bottom = up; bottom < rows; ++bottom) {
        for (int col = 0; col < cols; col++) {
          accumulatedSum[col] += matrix[bottom][col];
        }
//        System.out.println("up = " + up + ", bottom = " + bottom + ", sums = " + Arrays.toString(accumulatedSum));
        final int cur = maxSumArrayNoLargerThanK(accumulatedSum, k);
        max = Math.max(cur, max);
      }
    }
    return max;
  }

  private static int maxSumArrayNoLargerThanK(final int[] sums, final int k) {
    final TreeSet<Integer> accumulateSum = new TreeSet<>() {{
      add(0);
    }};
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < sums.length; ++i) {
      sum += sums[i];
      final Integer toRemove = accumulateSum.ceiling(sum - k);
      if (toRemove != null) {
        final int cur = sum - toRemove;
        max = Math.max(max, cur);
      }
      accumulateSum.add(sum);
    }
    return max;
  }
}
