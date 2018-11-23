package _0701_0750._727_Minimum_Window_Subsequence;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 * <p>
 * Example 1:
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 * Note:
 * <p>
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 */
public class Solution {
  private static final int INVALID = -1;

  public String minWindow(String S, String T) {
    /* dp[tIndex + 1][sIndex +1] is the start index index <code>k</code> to make sure
     *   1)  s.substring(k, sIndex + 1) contains t.substring(0, tIndex + 1)
     *   2)  k is the largest k that satisfies the condition above
     */
    final int[][] dp = new int[T.length() + 1][S.length() + 1];
    for (int sIndex = 0; sIndex < S.length(); sIndex++) {
      dp[0][sIndex + 1] = sIndex + 1;
    }
    for (int tIndex = 0; tIndex < T.length(); tIndex++) {
      dp[tIndex + 1][0] = INVALID;
    }

    for (int tIndex = 0; tIndex < T.length(); tIndex++) {
      for (int sIndex = 0; sIndex < S.length(); sIndex++) {
        if (S.charAt(sIndex) == T.charAt(tIndex)) {
          dp[tIndex + 1][sIndex + 1] = dp[tIndex][sIndex];
        } else {
          dp[tIndex + 1][sIndex + 1] = dp[tIndex + 1][sIndex];
        }
      }
    }

//    TwoDimensionArray.display2DimensionArray(dp);
    int start = -1, len = S.length();
    for (int sIndex = 0; sIndex < S.length(); sIndex++) {
      if (dp[T.length()][sIndex + 1] != INVALID && (sIndex - dp[T.length()][sIndex + 1] + 1 < len)) {
        start = dp[T.length()][sIndex + 1];
        len = sIndex - start + 1;
      }
    }

    return start == -1 ? "" : S.substring(start, start + len);
  }
}
