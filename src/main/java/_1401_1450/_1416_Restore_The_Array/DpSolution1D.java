package _1401_1450._1416_Restore_The_Array;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
public final class DpSolution1D implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private Integer[] dp;

  public int numberOfArrays(String s, int k) {
    dp = new Integer[s.length()];
    return numberOfArrays(s, k, 0);
  }

  private int numberOfArrays(final String s, final int k, final int i) {
    if (i == s.length()) {
      return 1;
    }
    if (dp[i] != null) {
      return dp[i];
    }
    if (s.charAt(i) == '0') return 0;
    int res = 0;
    long num = 0;
    for (int j = i; j < s.length(); ++j) {
      num = num * 10 + s.charAt(j) - '0';
      if (num > k) break;
      res = safeAdd(res, numberOfArrays(s, k, j + 1));
    }
    dp[i] = res;
    return res;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }
}
