package _0351_0400._357_Count_Numbers_with_Unique_Digits;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public class Solution {
  /**
   * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
   */
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    n = Math.min(n, 10);
    final int[] counts = new int[n + 1];
    final int[] permutation = new int[n + 1];
    permutation[1] = 9;
    for (int i = 2; i < permutation.length; ++i) {
      int k = 10 - i;
      permutation[i] = permutation[i - 1] * k;
    }

    counts[1] = 10;
    for (int i = 2; i < counts.length; ++i) {
      counts[i] = counts[i - 1] + 9 * permutation[i - 1];
    }
    return counts[n];
  }

}
