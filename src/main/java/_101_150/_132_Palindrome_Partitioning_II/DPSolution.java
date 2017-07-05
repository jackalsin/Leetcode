package _101_150._132_Palindrome_Partitioning_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class DPSolution implements Solution {
  public int minCut(String s) {
    int n = s.length();
    if (n == 0) return 0;
    final int[] minCut = new int[n]; // minCut[i] stands for minCut starting from
    Arrays.fill(minCut, n - 1);
    final boolean[][] isPal = new boolean[n][n]; // start, end, inclusive
    for (int start = n - 1; start >= 0; start--) {
      for (int end = n - 1; end >= start; end--) {
        if (s.charAt(start) == s.charAt(end) && (end - start < 2 || isPal[start + 1][end - 1])) {
          isPal[start][end] = true;
          if (end == n - 1) {
            minCut[start] = 0;
          } else {
            minCut[start] = Math.min(minCut[start], minCut[end + 1] + 1);
          }
        }
      }
    }
    return minCut[0];
  }
}
