package _0701_0750._718_Maximum_Length_of_Repeated_Subarray;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findLength(int[] A, int[] B) {
    final int m = A.length, n = B.length;
    final int[] dp = new int[n + 1];
    int max = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = n - 1; j >= 0; --j) {
        if (A[i] == B[j]) {
          dp[j + 1] = dp[j] + 1;
          max = Math.max(max, dp[j + 1]);
        } else {
          dp[j + 1] = 0;
        }
      }
    }
    return max;
  }
}
