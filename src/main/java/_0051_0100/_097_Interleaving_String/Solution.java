package _0051_0100._097_Interleaving_String;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/5/2017.
 */
public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < s1.length(); i++) {
      dp[0][i + 1] = dp[0][i] && (s1.charAt(i) == s3.charAt(i));
    }

    for (int i = 0; i < s2.length(); i++) {
      dp[i + 1][0] = dp[i][0] && (s2.charAt(i) == s3.charAt(i));
      for (int j = 0; j < s1.length(); j++) {
        dp[i + 1][j + 1] = (dp[i][j + 1] && (s2.charAt(i) == s3.charAt(i + j + 1)))
            || (dp[i + 1][j] && s1.charAt(j) == s3.charAt(i + j + 1));
      }
    }
    return dp[s2.length()][s1.length()];
  }

}
