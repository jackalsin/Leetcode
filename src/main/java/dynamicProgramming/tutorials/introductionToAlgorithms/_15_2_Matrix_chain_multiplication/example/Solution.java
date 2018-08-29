package dynamicProgramming.tutorials.introductionToAlgorithms._15_2_Matrix_chain_multiplication.example;

import java.util.Arrays;

public final class Solution {

  public int minMultiplication(final int[] p) {
    assert p != null && p.length >= 2;
    // A[i] has dimension of p[i], p[i + 1]
    final int n = p.length - 1; // number of matrix
    final int[][] dp = new int[n][n];
    // init dp with max int
    for (final int[] rows : dp) {
      Arrays.fill(rows, Integer.MAX_VALUE);
    }

    for (int row = n - 1; row >= 0; --row) {
      dp[row][row] = 0;
      for (int col = row + 1; col < n; col++) {
        for (int k = row; k + 1 <= col; k++) {
          dp[row][col] = Math.min(dp[row][col], dp[row][k] + dp[k + 1][col] + p[row] * p[k + 1] * p[col + 1]);
        }
      }
    }
//      TwoDimensionArray.display(dp);
    return dp[0][n - 1];
  }
}
