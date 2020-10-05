package oracle._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/27/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int coinChange(int[] coins, int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("amount should be greater than or equals to 0, but " + amount);
    }
    if (coins == null || coins.length == 0) {
      throw new IllegalArgumentException("coins cannot be empty or null.");
    }
    if (amount == 0) {
      return 0;
    }
    final int[] minCount = new int[amount + 1];
    Arrays.fill(minCount, Integer.MAX_VALUE);
    minCount[0] = 0;
    for (int a = 1; a <= amount; ++a) {
      for (int coin : coins) {
        final int remain = a - coin;
        if (remain >= 0 && minCount[remain] != Integer.MAX_VALUE) {
          minCount[a] = Math.min(minCount[a], minCount[remain] + 1);
        }
      }
    }
    return Integer.MAX_VALUE == minCount[amount] ? -1 : minCount[amount];
  }
}
