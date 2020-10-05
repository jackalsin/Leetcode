package dynamicProgramming._1397_Find_All_Good_Strings;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
public final class SolutionI implements Solution {
  private char[] s1 = null, s2 = null, evil = null;
  private int m, n;
  private int[] next;
  private static final int MOD = (int) (1e9 + 7);
  private Integer[][][][] dp;

  public int findGoodStrings(int n, String s1, String s2, String evil) {
    this.s1 = s1.toCharArray();
    this.s2 = s2.toCharArray();
    this.evil = evil.toCharArray();
    this.n = n;
    this.m = evil.length();
    this.next = getNext(evil);
    dp = new Integer[n][2][2][evil.length()];
//    System.out.println(Arrays.toString(this.next));
    return findGoodStrings(0, true, true, 0);
  }

  private int findGoodStrings(final int i, final boolean isPrefix1, final boolean isPrefix2, final int evilPtr) {
    if (evilPtr == m) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    final int k1 = isPrefix1 ? 0 : 1, k2 = isPrefix2 ? 0 : 1;
    if (dp[i][k1][k2][evilPtr] != null) {
      return dp[i][k1][k2][evilPtr];
    }
    int res = 0;
    final char start = isPrefix1 ? s1[i] : 'a',
        end = isPrefix2 ? s2[i] : 'z';
    for (char chr = start; chr <= end; ++chr) {
      int nextPtr = evilPtr;
      // 找到改到点
      while (!(nextPtr == -1 || chr == evil[nextPtr])) {
        nextPtr = next[nextPtr];
      }
      if (nextPtr == -1 || chr == evil[nextPtr]) {
        nextPtr++;
      }
      final int cur = findGoodStrings(i + 1, isPrefix1 && chr == start, isPrefix2 && chr == end, nextPtr);
      res = safeAdd(res, cur);
    }
    dp[i][k1][k2][evilPtr] = res;
    return res;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }

  private static int[] getNext(final String evil) {
    if (evil.isEmpty()) {
      return new int[0];
    }
    final int n = evil.length();
    final int[] next = new int[n];
    next[0] = -1;
    int j = 0, k = -1;
    while (j < evil.length() - 1) {
      if (k == -1 || evil.charAt(j) == evil.charAt(k)) {
        ++k;
        ++j;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }
}
