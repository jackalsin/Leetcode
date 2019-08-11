package interviews.linkedin._322_Coin_Change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author jacka
 * @version 1.0 on 8/10/2019
 */
public final class DfsSolutionI implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return 0;
    }
    Arrays.sort(coins);
    reverse(coins);
    final int res = coinChangeHelper(coins, amount);
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private static void reverse(final int[] nums) {
    for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
      final int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

  private int coinChangeHelper(final int[] coins, final int amount) {
    if (amount < 0) {
      return Integer.MAX_VALUE;
    }
    if (amount == 0) {
      return 0;
    }
    if (cache.containsKey(amount)) {
      return cache.get(amount);
    }
    int count = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin > amount) continue;
      final int cur = coinChangeHelper(coins, amount - coin);
      if (cur == Integer.MAX_VALUE) continue;
      count = Math.min(cur + 1, count);
    }
    cache.put(amount, count);
    return count;
  }
}
