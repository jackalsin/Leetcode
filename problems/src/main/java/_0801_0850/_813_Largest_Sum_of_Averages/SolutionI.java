package _0801_0850._813_Largest_Sum_of_Averages;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  private double[][] dp;
  private double[] sum;
  private int n;

  public double largestSumOfAverages(int[] A, int K) {
    n = A.length;
    sum = new double[n + 1];
    for (int i = 0; i < n; ++i) {
      sum[i + 1] = sum[i] + A[i];
    }
    dp = new double[n][K + 1];
    return helper(0, K);
  }

  private double helper(int start, final int remainK) {
    if (dp[start][remainK] != 0) return dp[start][remainK];
    if (remainK <= 1) {
      return sum(start, n - 1) / (n - start);
    }
    double max = 0;
    for (int i = start; i + remainK <= n; ++i) {
      final double cur = sum(start, i) / (i - start + 1)
          + helper(i + 1, remainK - 1);
      max = Math.max(max, cur);
    }
    dp[start][remainK] = max;
    return max;
  }

  private double sum(int start, int end) {
    return sum[end + 1] - sum[start];
  }
}
