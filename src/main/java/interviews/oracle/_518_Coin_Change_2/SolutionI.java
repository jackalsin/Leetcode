package interviews.oracle._518_Coin_Change_2;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int change(int amount, int[] coins) {
    final int n = coins.length;
    final int[][] dp = new int[n + 1][amount + 1];
    dp[0][0] = 1;
    for (int i = 0; i < coins.length; ++i) {
      dp[i + 1][0] = 1;
      final int coin = coins[i];
      for (int j = 1; j <= amount; ++j) {
        dp[i + 1][j] = dp[i][j] + (j >= coin ? dp[i + 1][j - coin] : 0);
      }
    }
    return dp[n][amount];
  }
}
