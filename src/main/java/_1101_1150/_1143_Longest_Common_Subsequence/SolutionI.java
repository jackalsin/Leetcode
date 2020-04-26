package _1101_1150._1143_Longest_Common_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 4/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int longestCommonSubsequence(String text1, String text2) {
    final int m = text1.length(), n = text2.length();
    int[] prev = new int[n + 1];
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < text1.length(); ++i) {
      int[] next = new int[n + 1];
      for (int j = 0; j < text2.length(); ++j) {
        if (text1.charAt(i) == text2.charAt(j)) {
          next[j + 1] = Math.max(prev[j] + 1, next[j + 1]);
        } else {
          next[j + 1] = Math.max(prev[j], next[j + 1]);
        }
        next[j + 1] = Math.max(next[j + 1], prev[j + 1]);
        next[j + 1] = Math.max(next[j + 1], next[j]);
      }
      prev = next;
//      System.out.println(Arrays.toString(prev));
    }
    return prev[n];
  }
}
