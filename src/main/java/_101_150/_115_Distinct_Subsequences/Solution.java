package _101_150._115_Distinct_Subsequences;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class Solution {
  /**
   * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
   * @param s source string
   * @param t
   * @return
   */
  public int numDistinct(String s, String t) {
    int[][] dp = new int[t.length() + 1][s.length() + 1];
    dp[0][0] = 1;
    for (int i = 0; i < s.length(); i++) {
      dp[0][i + 1] = 1;
    }
    for (int i = 0; i < t.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          // triangle means no remove, while the same row means remove the current one
          dp[i + 1][j + 1] = dp[i][j] + dp[i+1][j];
        } else {
          dp[i + 1][j + 1] = dp[i + 1][j];
        }
      }
    }
    return dp[t.length()][s.length()];
  }
}
