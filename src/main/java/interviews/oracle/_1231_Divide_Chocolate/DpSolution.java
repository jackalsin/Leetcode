package interviews.oracle._1231_Divide_Chocolate;

/**
 * @author jacka
 * @version 1.0 on 12/5/2019
 */
public final class DpSolution implements Solution {
  @Override
  public int maximizeSweetness(int[] sweetness, int K) {
    if (sweetness == null || sweetness.length == 0) {
      return 0;
    }
    K++;
    final int n = sweetness.length;

    final int[][] dp = new int[K + 1][n];
    System.arraycopy(sweetness, 0, dp[0], 0, n);
    for (int i = 0; i < n; ++i) {
      dp[1][i] = (i == 0 ? 0 : dp[1][i - 1]) + sweetness[i];
    }
    for (int i = 2; i <= K; ++i) {
      dp[i][i - 1] = Math.min(sweetness[i - 1], dp[i - 1][i - 2]);
      for (int j = i; j < n; ++j) {
        int max = 0;
        for (int start = i - 1; start <= j; start++) {
          final int curSum = getSum(dp[1], start, j);
          max = Math.max(max, Math.min(curSum, dp[i - 1][start - 1]));
        }
//        dp[i][j] = Math.max(dp[i][j - 1], min);
        dp[i][j] = max;
      }
    }
//    display(dp);
    return dp[K][n - 1];
  }

  private static int getSum(final int[] sums, final int start, int end) {
    assert start > 0;
    return sums[end] - sums[start - 1];
  }
}
