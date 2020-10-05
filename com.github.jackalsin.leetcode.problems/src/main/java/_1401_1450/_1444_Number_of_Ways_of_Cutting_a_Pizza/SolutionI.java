package _1401_1450._1444_Number_of_Ways_of_Cutting_a_Pizza;


import java.util.Arrays;

public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private final int[][][] dp = new int[11][51][51];
  /**
   * presum [r:][c:]
   */
  private final int[][] preSum = new int[51][51];

  {
    for (final int[][] board : dp) {
      for (final int[] r : board) {
        Arrays.fill(r, -1);
      }
    }
  }

  private int rows = 0, cols = 0;

  public int ways(String[] pizza, int k) {
    rows = pizza.length;
    cols = pizza[0].length();
    for (int row = rows - 1; row >= 0; --row) {
      for (int col = cols - 1; col >= 0; --col) {
        preSum[row][col] =
            preSum[row][col + 1] + preSum[row + 1][col] - preSum[row + 1][col + 1]
                + (pizza[row].charAt(col) == 'A' ? 1 : 0);
      }
    }
    return dfs(0, 0, k);
  }

  private int dfs(final int row, final int col, final int remainCut) {
    if (preSum[row][col] == 0) return 0;
    if (dp[remainCut][row][col] != -1) {
      return dp[remainCut][row][col];
    }
    if (row >= rows || col >= cols) return 0;
    if (remainCut == 1) {
      return 1;
    }
    int count = 0;
    // vertical
    for (int nextStartCol = col + 1; nextStartCol < cols; ++nextStartCol) {
      // make sure there is an apple 被割掉的部分
      if (preSum[row][col] - preSum[row][nextStartCol] > 0) {
        count = safeAdd(count, dfs(row, nextStartCol, remainCut - 1));
      }
    }
    // horizontal
    for (int nextStartRow = row + 1; nextStartRow < rows; ++nextStartRow) {
      if (preSum[row][col] - preSum[nextStartRow][col] > 0) {
        count = safeAdd(count, dfs(nextStartRow, col, remainCut - 1));
      }
    }
    dp[remainCut][row][col] = count;
    return count;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }

}