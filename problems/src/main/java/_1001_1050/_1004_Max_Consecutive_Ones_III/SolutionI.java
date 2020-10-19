package _1001_1050._1004_Max_Consecutive_Ones_III;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
public final class SolutionI implements Solution {

  public int longestOnes(int[] A, int K) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int n = A.length;
    int maxLen = 0;
    for (int left = 0, right = 0; right < n; ++right) {
      if (A[right] == 0) K--;
      while (K < 0) {
        if (A[left] == 0) {
          K++;
        }
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }
}
