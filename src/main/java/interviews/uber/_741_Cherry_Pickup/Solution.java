package interviews.uber._741_Cherry_Pickup;

import java.util.Arrays;

public final class Solution {
  private int N;
  private int[][][] dp;
  private int[][] grid;

  public int cherryPickup(int[][] grid) {
    this.grid = grid;
    this.N = grid.length;
    dp = new int[N][N][N];
    for (final int[][] b : dp) {
      for (final int[] row : b) {
        Arrays.fill(row, Integer.MIN_VALUE);
      }
    }

    return Math.max(0, dp(0, 0, 0));
  }

  private int dp(final int r1, final int c1, final int c2) {
    final int r2 = r1 + c1 - c2;
    if (r1 == N || r2 == N || c1 == N || c2 == N || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }

    if (r1 == N - 1 && c1 == N - 1) {
      assert r2 == N - 1 && c2 == N - 1;
      dp[r1][c1][c2] = grid[r1][c1];
      return grid[r1][c1];
    } else if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
      return dp[r1][c1][c2];
    } else {
      int res = grid[r1][c1];
      if (r1 != r2) {
        res += grid[r2][c2];
      }
      res += max(dp(r1 + 1, c1, c2), dp(r1 + 1, c1, c2 + 1),
          dp(r1, c1 + 1, c2), dp(r1, c1 + 1, c2 + 1));
      dp[r1][c1][c2] = res;
      return res;
    }

  }

  private static int max(final int a, final int... array) {
    int res = a;
    for (int elem : array) {
      res = Math.max(elem, res);
    }
    return res;
  }
}
