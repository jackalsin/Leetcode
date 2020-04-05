package interviews.google._727_Minimum_Window_Subsequence;

import utils.TwoDimensionArray;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionI implements Solution {
  public String minWindow(String S, String T) {
    if (S == null || T == null || T.isEmpty()) {
      return "";
    }
    final int[][] dp = new int[T.length()][S.length()];
    for (final int[] d : dp) {
      Arrays.fill(d, -1);
    }
    for (int s = 0; s < S.length(); ++s) {
      final char tChar = T.charAt(0), sChar = S.charAt(s);
      if (tChar == sChar) {
        dp[0][s] = s;
      }
    }
    for (int t = 1; t < T.length(); ++t) {
      final char tChar = T.charAt(t);
      int prev = -1;
      for (int s = 0; s < S.length(); ++s) {
        final char sChar = S.charAt(s);
        if (sChar == tChar && prev != -1) {
          dp[t][s] = prev;
        }
        if (dp[t - 1][s] >= 0) {
          prev = dp[t - 1][s];
        }
      }
    }
//    TwoDimensionArray.toString(dp);
    int minLen = Integer.MAX_VALUE, minStart = -1;
    for (int end = 0; end < S.length(); ++end) {
      final int start = dp[T.length() - 1][end];
      if (start >= 0) {
        final int curLen = end - start + 1;
        if (curLen < minLen) {
          minStart = start;
          minLen = curLen;
        }
      }
    }
    return minStart == -1 ? "" : S.substring(minStart, minStart + minLen);
  }
}
