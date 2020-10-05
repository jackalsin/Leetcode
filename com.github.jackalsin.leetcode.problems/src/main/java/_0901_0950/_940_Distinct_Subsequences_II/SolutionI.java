package _0901_0950._940_Distinct_Subsequences_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/23/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  /**
   * <a herf='https://leetcode.com/problems/distinct-subsequences-ii/discuss/192017/C%2B%2BJavaPython-4-lines-O(N)-Time-O(1)-Space'></a>
   */
  public int distinctSubseqII(String s) {
    final long[] endWith = new long[26];

    for (final char chr : s.toCharArray()) {
      endWith[chr - 'a'] = (Arrays.stream(endWith).sum() + 1) % MOD;
    }
    return (int) (Arrays.stream(endWith).sum() % MOD);
  }
}
