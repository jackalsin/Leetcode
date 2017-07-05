package _101_150._132_Palindrome_Partitioning_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/4/2017.
 */
public class BitchingSolution implements Solution {
  /**
   * minCut[i] stands for mincuts needed ending on ith, inclusive.
   */
  private int[] minCut;
  public int minCut(String s) {
    if (s.length() == 0) return 0;
    minCut = new int[s.length()];
    Arrays.fill(minCut, s.length() - 1);
    for (int i = 0; i < s.length(); i++) {
      updateMinCut(s, i, i);
      updateMinCut(s, i, i + 1);
    }
    return minCut[s.length() - 1];
  }

  private void updateMinCut(String s, int left, int right) {
    while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
      if (left == 0) {
        minCut[right] = 0;
      } else {
        minCut[right] = Math.min(minCut[left - 1] + 1, minCut[right]);
      }
      left--;
      right++;
    }
  }
}
