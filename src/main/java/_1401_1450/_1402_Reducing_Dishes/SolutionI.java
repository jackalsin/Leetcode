package _1401_1450._1402_Reducing_Dishes;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/23/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSatisfaction(int[] satisfaction) {
    final int n = satisfaction.length;
    Arrays.sort(satisfaction);
//    System.out.println(Arrays.toString(satisfaction));
    final int[][] dp = new int[n + 1][n + 1];
    for (int i = 0; i < n; ++i) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < n; ++j) {
        dp[i + 1][j + 1] = Math.max(max, dp[i][j] + (i + 1) * satisfaction[j]);
        max = Math.max(dp[i + 1][i + 1], max);
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= n; ++i) {
      max = Math.max(max, dp[i][n]);
    }
    return max;
  }
}
