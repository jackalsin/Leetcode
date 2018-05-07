package _501_550._518_Coin_Change_2;

public class Solution {

  public int change(int amount, int[] coins) {
    final int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;

    for (int i = 0; i < coins.length; i++) {
      dp[i + 1][0] = 1;
      for (int j = 1; j <= amount; j++) {
        // dp[i][j] 是用前i - 1 个硬币做到的，显然就算有第i个硬币，这部分肯定可以
        // 而用上第i个硬币，就是用了这个硬币考虑当amount 为 amount - coins[i]的
        dp[i + 1][j] = dp[i][j] + (j >= coins[i] ? dp[i + 1][j - coins[i]] : 0);
      }
    }
    return dp[coins.length][amount];
  }

}
