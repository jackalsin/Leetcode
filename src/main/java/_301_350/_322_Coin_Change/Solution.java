package _301_350._322_Coin_Change;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class Solution {
  /**
   * Recursion Solution
   *
   * Runtime: 42 ms
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    final int[] counts = new int[amount];
    return coinChange(coins, counts, amount);
  }

  private int coinChange(int[] coins, int[] counts, int amount) {
    if (amount == 0) return 0;
    if (amount < 0) return -1;
    if (counts[amount - 1] != 0) return counts[amount - 1];
    int minCount = Integer.MAX_VALUE;
    for (int coin: coins) {
      int count = coinChange(coins, counts, amount - coin) + 1;
      if (count != 0 && minCount > count) {
        minCount = count;
      }
    }
    counts[amount - 1] = minCount == Integer.MAX_VALUE ? -1 : minCount;
    return counts[amount - 1];
  }
}
