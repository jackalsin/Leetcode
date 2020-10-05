package _0301_0350._312_Burst_Balloons;

/**
 * @author jacka
 * @version 1.0 on 9/17/2017.
 */
public class Solution {

  public int maxCoins(int[] nums) {
    final int n = nums.length;
    final int[] balloons = new int[n + 2];
    System.arraycopy(nums, 0, balloons, 1, n);
    balloons[0] = balloons[n + 1] = 1;
    /* dp stands for the max coin you can get by bursting all balloons between start(exclusive)
    and end(exclusive) */
    final int[][] dp = new int[n + 2][n + 2];
    for (int len = 2; len < balloons.length; ++len) {
      for (int start = 0; start < balloons.length - len; ++start) {
        int end = start + len;
        for (int i = start + 1; i < end; ++i) {
          dp[start][end] = Math.max(dp[start][end],
              dp[start][i] + dp[i][end]
                  + balloons[start] * balloons[i] * balloons[end]);
        }
      }
    }
    return dp[0][balloons.length - 1];
  }
}
