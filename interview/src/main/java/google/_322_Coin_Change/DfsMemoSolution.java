package google._322_Coin_Change;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
public final class DfsMemoSolution implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0) return -1;
    if (amount == 0) return 0;
    return coinChangeHelper(coins, amount);
  }

  private int coinChangeHelper(final int[] coins, final int amount) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;
    if (cache.containsKey(amount)) return cache.get(amount);
    long res = Long.MAX_VALUE;
    for (final int coin : coins) {
      final int prev = coinChange(coins, amount - coin);
      if (prev == -1) continue;
      res = Math.min(res, prev + 1);
    }
    res = res == Long.MAX_VALUE ? -1 : (int) res;
    cache.put(amount, (int) res);
    return (int) res;
  }
}
