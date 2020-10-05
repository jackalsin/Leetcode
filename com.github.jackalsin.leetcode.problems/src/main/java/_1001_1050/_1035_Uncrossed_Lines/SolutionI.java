package _1001_1050._1035_Uncrossed_Lines;

public final class SolutionI implements Solution {
  /**
   * The longest common sequence
   *
   * @param A
   * @param B
   * @return
   */
  public int maxUncrossedLines(int[] A, int[] B) {
    final int m = A.length, n = B.length;
    final int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i] == B[j]) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }
    return dp[m][n];
  }
}
