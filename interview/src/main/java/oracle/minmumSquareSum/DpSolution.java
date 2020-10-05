package oracle.minmumSquareSum;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public final class DpSolution implements Solution {
  @Override
  public int getMinSquareSum(int sum) {
    if (sum < 0) {
      throw new IllegalStateException("Sum should be greater than 0, but now = " + sum);
    }
    if (sum < 2) {
      return sum;
    }
    final int[] dp = new int[sum + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= sum; ++i) {
      dp[i] = i;
      for (int t = 1; t <= i / t; t++) {
        dp[i] = Math.min(dp[i], 1 + dp[i - t * t]);
      }
    }
//    System.out.println(Arrays.toString(dp));
    return dp[sum];
  }
}
