package apple._1547_Minimum_Cost_to_Cut_a_Stick;


import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/1/2021
 */
public final class SolutionI implements Solution {

  public int minCost(int n, int[] cuts) {
    final int N = cuts.length + 2;
    final int[] nums = new int[N];
    nums[N - 1] = n;
    System.arraycopy(cuts, 0, nums, 1, cuts.length);
    Arrays.sort(nums);
    final int[][] dp = new int[N][N];

    for (int i = N - 2; i >= 0; --i) {
      for (int j = i + 2; j < N; ++j) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
          dp[i][j] = Math.min(dp[i][j],
              nums[j] - nums[i] + dp[i][k] + dp[k][j]);
        }
      }
    }
    return dp[0][N - 1];
  }
}
