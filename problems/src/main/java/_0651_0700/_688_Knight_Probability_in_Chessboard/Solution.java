package _0651_0700._688_Knight_Probability_in_Chessboard;


public class Solution {
  private static final int[][] DIRS = {
      {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
      {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
  };

  public double knightProbability(int N, int K, int r, int c) {
    final double[][][] dp = new double[K + 1][N][N];
    dfsMemo(dp, N, K, r, c);
    return dp[K][r][c] / Math.pow(8.0, K);
  }

  private static double dfsMemo(final double[][][] dp, final int N, int k, final int r, final int c) {
    if (!isValid(r, c, N)) {
      return 0d;
    } else if (k == 0) {
      dp[k][r][c] = 1;
      return 1;
    } else if (dp[k][r][c] != 0) {
      return dp[k][r][c];
    } else {
      double sum = 0d;
      for (final int[] d : DIRS) {
        sum += dfsMemo(dp, N, k - 1, r + d[0], c + d[1]);
      }
      dp[k][r][c] = sum;
      return sum;
    }
  }

  private static boolean isValid(final int r, final int c, final int N) {
    return 0 <= r && r < N && 0 <= c && c < N;
  }
}
