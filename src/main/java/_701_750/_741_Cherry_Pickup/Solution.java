package _701_750._741_Cherry_Pickup;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public final class Solution {
  private int[][][] dp;
  private int[][] grid;
  private int N;
  private static final int NOT_VISITED = Integer.MIN_VALUE;
  private static final int BLOCK = -1;

  public int cherryPickup(int[][] grid) {
    N = grid.length;
    dp = new int[N][N][N];
    this.grid = grid;
    for (final int[][] layer : dp) {
      for (final int[] d : layer) {
        Arrays.fill(d, NOT_VISITED);
      }
    }
    int res = Math.max(0, dp(0, 0, 0));
    System.out.println(Arrays.deepToString(dp));
    return res;
  }

  private int dp(int r1, int c1, int r2) {
    final int c2 = r1 + c1 - r2;
    if (r1 == N || r2 == N || c1 == N || c2 == N || grid[r1][c1] == BLOCK || grid[r2][c2] ==
        BLOCK) {
      return BLOCK;
    } else if (r1 == N - 1 && c1 == N - 1) {
      assert r2 == N - 1;
      dp[r1][c1][r2] = grid[r1][c1];
      return grid[r1][c1];
    } else if (dp[r1][c1][r2] != NOT_VISITED) {
      return dp[r1][c1][r2];
    } else {
      int ans = grid[r1][c1];
      if (c1 != c2) {
        ans += grid[r2][c2];
      }
      int prev = Math.max(
          // person 1 down, p2, down            // p1 down, p2 right
          Math.max(dp(r1 + 1, c1, r2 + 1), dp(r1 + 1, c1, r2)),
          // p1 right, p2 down,                   // p2 right, p2 right
          Math.max(dp(r1, c1 + 1, r2 + 1), dp(r1, c1 + 1, r2))
      );
      if (prev == BLOCK) {
        ans = BLOCK;
      } else {
        ans += prev;
      }
      dp[r1][c1][r2] = ans;
      return ans;
    }
  }
}
