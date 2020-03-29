package _1351_1400._1397_Find_All_Good_Strings;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private int[][][] dp;
  private int m, n;
  private int[] next;
  private char[] s1 = null, s2 = null, evil = null;

  public int findGoodStrings(int n, String s1, String s2, String evil) {
    m = evil.length();
    this.n = n;
    dp = new int[n + 1][4][evil.length()];
    this.s1 = s1.toCharArray();
    this.s2 = s2.toCharArray();
    this.evil = evil.toCharArray();
    for (final int[][] b : dp) {
      for (final int[] r : b) {
        Arrays.fill(r, -1);
      }
    }
    next = getNext(this.evil);
    System.out.println(Arrays.toString(next));
    return findGoodStrings(0, 0, true, true);
  }

  private int findGoodStrings(final int i, final int prefixEval, final boolean isPrefix1, final boolean isPrefix2) {
    if (prefixEval == m) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    final int midKey = getState(isPrefix1, isPrefix2);
    if (dp[i][midKey][prefixEval] != -1) {
      return dp[i][midKey][prefixEval];
    }
    int res = 0;
    final char minChar = isPrefix1 ? s1[i] : 'a',
        maxChar = isPrefix2 ? s2[i] : 'z';
    for (char chr = minChar; chr <= maxChar; chr++) {
      int nextPrefixEval = prefixEval;
      while (nextPrefixEval > 0 && chr != evil[nextPrefixEval]) {
        nextPrefixEval = next[nextPrefixEval - 1];
      }
      if (chr == evil[nextPrefixEval]) {
        nextPrefixEval++;
      }
      final int cur = findGoodStrings(i + 1, nextPrefixEval, isPrefix1 && chr == minChar,
          isPrefix2 && chr == maxChar);
      res = safeAdd(cur, res);
    }
    dp[i][midKey][prefixEval] = res;
    return res;
  }

  private static int getState(final boolean a, final boolean b) {
    final int val1 = a ? 1 : 0, val2 = b ? 1 : 0;
    return (val1 << 1) | val2;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }

  static int[] getNext(final char[] pattern) {
    final int n = pattern.length;
    final int[] next = new int[n];
    for (int i = 1, j = 0; i < n; ) {
      while (j > 0 && pattern[j] != pattern[i]) {
        j = next[j - 1];
      }
      if (pattern[i] == pattern[j]) {
        j += 1;
      }
      next[i] = j;
      i++;
    }
    return next;
  }
}
