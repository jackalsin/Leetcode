package _0901_0950._940_Distinct_Subsequences_II;

/**
 * @author jacka
 * @version 1.0 on 9/23/2020
 */
public final class SolutionII implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int distinctSubseqII(String s) {
    final int[] ends = new int[26];
    int res = 0;
    for (final char chr : s.toCharArray()) {
      final int toAdd = (res - ends[chr - 'a'] + 1) % MOD;
      res = (res + toAdd) % MOD;
      ends[chr - 'a'] = (ends[chr - 'a'] + toAdd) % MOD;
    }
    return (res + MOD) % MOD;
  }
}
