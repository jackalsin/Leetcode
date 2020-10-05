package _0551_0600._576_Out_of_Boundary_Paths;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int findPaths(int rows, int cols, int N, int row, int col) {
    final int[][][] dp = new int[N + 1][rows][cols];
    for (int n = 1; n <= N; ++n) {
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          int res = 0;
          if (c == 0) {
            res++;
          }
          if (r == 0) {
            res++;
          }
          if (r == rows - 1) {
            res++;
          }
          if (c == cols - 1) {
            res++;
          }
          res = safeAdd(res, getLastLayer(dp, n - 1, r - 1, c));
          res = safeAdd(res, getLastLayer(dp, n - 1, r + 1, c));
          res = safeAdd(res, getLastLayer(dp, n - 1, r, c - 1));
          res = safeAdd(res, getLastLayer(dp, n - 1, r, c + 1));
          dp[n][r][c] = res;
        }
      }
    }
    return dp[N][row][col];
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }

  private static int getLastLayer(int[][][] dp, int n, int row, int col) {
    final int rows = dp[0].length, cols = dp[0][0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      return 0;
    }
    return dp[n][row][col];
  }
}
