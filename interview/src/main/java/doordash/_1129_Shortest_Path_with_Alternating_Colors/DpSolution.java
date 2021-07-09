package doordash._1129_Shortest_Path_with_Alternating_Colors;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 7/8/2021
 */
public final class DpSolution implements Solution {
  private static final int RED = 0, BLUE = 1;

  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    final int[][][] dp = new int[2][2 * n][n];
    Arrays.fill(dp[RED][0], -1);
    Arrays.fill(dp[BLUE][0], -1);
    dp[RED][0][0] = dp[BLUE][0][0] = 0;
    for (int i = 1; i < 2 * n; ++i) {
      System.arraycopy(dp[RED][i - 1], 0, dp[RED][i], 0, n);
      updateRow(dp[BLUE], dp[RED], red_edges, i);
      System.arraycopy(dp[BLUE][i - 1], 0, dp[BLUE][i], 0, n);
      updateRow(dp[RED], dp[BLUE], blue_edges, i);
    }
    final int[] res = new int[n];
    for (int i = 0; i < n; ++i) {
      if (dp[0][2 * n - 1][i] == -1 && dp[1][2 * n - 1][i] == -1) {
        res[i] = -1;
      } else if (dp[0][2 * n - 1][i] == -1) {
        res[i] = dp[1][2 * n - 1][i];
      } else if (dp[1][2 * n - 1][i] == -1) {
        res[i] = dp[0][2 * n - 1][i];
      } else {
        res[i] = Math.min(dp[0][2 * n - 1][i], dp[1][2 * n - 1][i]);
      }
    }
//    TwoDimensionArray.println(dp[0]);
//    TwoDimensionArray.println(dp[1]);
    return res;
  }

  private void updateRow(final int[][] srcDp, final int[][] dstDp, final int[][] edges, final int row) {
    for (int[] bg : edges) {
      final int src = bg[0], dst = bg[1];
      if (srcDp[row - 1][src] == -1 || dstDp[row][dst] != -1) continue;
      dstDp[row][dst] = srcDp[row - 1][src] + 1;
    }
  }
}
