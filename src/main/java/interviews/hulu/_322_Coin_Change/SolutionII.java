package interviews.hulu._322_Coin_Change;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/25/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int coinChange(int[] coins, int amount) {
    final long[] minCount = new long[amount + 1];
    Arrays.fill(minCount, Long.MAX_VALUE);
    minCount[0] = 0;
    for (int i = 0; i <= amount; ++i) {
      if (minCount[i] == Long.MAX_VALUE) {
        continue;
      }
      for (int c : coins) {
        if ((long) i + c > amount) continue;
        minCount[i + c] = Math.min(minCount[i + c], minCount[i] + 1);
      }
    }
    return minCount[amount] == Long.MAX_VALUE ? -1 : (int) minCount[amount];
  }
}
