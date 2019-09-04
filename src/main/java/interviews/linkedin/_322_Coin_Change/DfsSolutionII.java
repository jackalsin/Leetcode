package interviews.linkedin._322_Coin_Change;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class DfsSolutionII implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    if (cache.containsKey(amount)) return cache.get(amount);
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      final int cur = coinChange(coins, amount - coin);
      if (cur == -1) continue;
      res = Math.min(res, 1 + cur);
    }
    if (res == Integer.MAX_VALUE) {
      res = -1;
    }
    cache.put(amount, res);
    return res;
  }
}
