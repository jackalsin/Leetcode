package linkedin._322_Coin_Change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class DfsSolution implements Solution {

  public int coinChange(int[] coins, int amount) {
    if (coins == null) {
      return -1;
    }
    if (coins.length == 0) {
      return amount == 0 ? 0 : -1;
    }
    final Map<Integer, Integer> amountToCount = new HashMap<>();

    Arrays.sort(coins);
    reverse(coins);
    return coinChange(amountToCount, coins, amount);
  }

  private static void reverse(int[] coins) {
    int left = 0, right = coins.length - 1;
    while (left < right) {
      int tmp = coins[left];
      coins[left] = coins[right];
      coins[right] = tmp;
      ++left;
      --right;
    }
  }

  private static int coinChange(final Map<Integer, Integer> amountToCount, final int[] coins, final int amount) {
    if (amount < 0) {
      return -1;
    } else if (amount == 0) {
      return 0;
    }

    if (amountToCount.containsKey(amount)) {
      return amountToCount.get(amount);
    }

    int count = Integer.MAX_VALUE;
    for (int coin : coins) {
      int moreCount = coinChange(amountToCount, coins, amount - coin);
      if (moreCount == -1) {
        continue;
      }
      count = Math.min(count, moreCount + 1);
    }
    assert count >= 0;
    count = count == Integer.MAX_VALUE ? -1 : count;
    amountToCount.put(amount, count);
    return count;
  }
}
