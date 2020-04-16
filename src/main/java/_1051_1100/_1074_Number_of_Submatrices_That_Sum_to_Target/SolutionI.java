package _1051_1100._1074_Number_of_Submatrices_That_Sum_to_Target;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
public final class SolutionI implements Solution {
  /**
   * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum
   */
  @Override
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    final int rows = matrix.length, cols = matrix[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 1; col < cols; ++col) {
        matrix[row][col] += matrix[row][col - 1];
      }
    }

    int res = 0;
    /*loop every pair [col_left, col_right]
    * and pretend this is the subarray sum equals to target problem*/
    for (int left = 0; left < cols; left++) {
      for (int right = left; right < cols; right++) {
        final Map<Integer, Integer> sumToCount = new HashMap<>() {{
          put(0, 1);
        }};
        int curSum = 0;
        for (int row = 0; row < rows; row++) {
          curSum += matrix[row][right] - (left == 0 ? 0 : matrix[row][left - 1]);
          res += sumToCount.getOrDefault(curSum - target, 0);
          sumToCount.put(curSum, sumToCount.getOrDefault(curSum, 0) + 1);
        }
      }
    }
    return res;
  }
}
