package interviews.linkedin._518_Coin_Change_2;

public final class SolutionIII implements Solution {
  public int change(int amount, int[] coins) {
    final int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }
}
