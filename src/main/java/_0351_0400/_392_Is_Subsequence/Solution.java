package _0351_0400._392_Is_Subsequence;

public class Solution {
  /**
   * @param s the sequence
   * @param t the entire string
   * @return
   */
  public boolean isSubsequence(String s, String t) {
    final boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];
    dp[0][0] = true;
    for (int tt = 0; tt < t.length(); tt++) {
      dp[tt + 1][0] = true; // the upper row is always true
      for (int ss = 0; ss < s.length(); ss++) {
        dp[tt + 1][ss + 1] = dp[tt][ss + 1] || (s.charAt(ss) == t.charAt(tt) && dp[tt][ss]);
      }
    }
    return dp[t.length()][s.length()];
  }
}
