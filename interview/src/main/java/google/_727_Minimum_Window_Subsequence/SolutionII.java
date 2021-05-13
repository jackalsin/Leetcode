package google._727_Minimum_Window_Subsequence;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/12/2021
 */
public final class SolutionII implements Solution {
  @Override
  public String minWindow(String S, String T) {
    if (S == null || T == null || S.length() == 0 || T.length() == 0) return "";
    final int m = S.length(), n = T.length();
    final int[][] dp = new int[n][m];
    for (final int[] row : dp) Arrays.fill(row, -1);
    for (int i = 0; i < m; ++i) {
      if (S.charAt(i) == T.charAt(0)) dp[0][i] = i;
      else dp[0][i] = i > 0 ? dp[0][i - 1] : -1;
    }
    for (int i = 1; i < n; ++i) {
      for (int j = i; j < m; ++j) {
        if (S.charAt(j) == T.charAt(i)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }
//    TwoDimensionArray.println(dp);
    int minStart = -1;
    long minLen = Long.MAX_VALUE;
    for (int i = 1; i < m; ++i) {
      if (dp[n - 1][i] == -1) continue;
      final int curLen = i - dp[n - 1][i] + 1;
      if (curLen < minLen) {
        minLen = curLen;
        minStart = dp[n - 1][i];
      }
    }
    return minStart == -1 ? "" : S.substring(minStart, (int) (minStart + minLen));
  }
}
