package _751_800._764_Largest_Plus_Sign;

//import utils.TwoDimensionArray;

import java.util.Arrays;

public class Solution {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
    final int[][] board = new int[N][N];
    final int[][] dp = new int[N][N];
    for (int[] row : board) {
      Arrays.fill(row, 1);
    }

    for (int[] mine : mines) {
      board[mine[0]][mine[1]] = 0;
    }

//    TwoDimensionArray.display2DimensionArray(board);

    // scan left to right
    for (int row = 0; row < N; row++) {
      int count = 0;
      for (int col = 0; col < N; col++) {
        if (board[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        dp[row][col] = count;
      }
    }
//    TwoDimensionArray.display2DimensionArray(dp);

    // scan right to left
    for (int row = 0; row < N; row++) {
      int count = 0;
      for (int col = N - 1; col >= 0; col--) {
        if (board[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        dp[row][col] = Math.min(count, dp[row][col]);
      }
    }

//    TwoDimensionArray.display2DimensionArray(dp);
    // scan up to down
    for (int col = 0; col < N; col++) {
      int count = 0;
      for (int row = 0; row < N; row++) {
        if (board[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        dp[row][col] = Math.min(count, dp[row][col]);
      }
    }

    // scan down to up
    int res = 0;
    for (int col = 0; col < N; col++) {
      int count = 0;

      for (int row = N - 1; row >= 0; row--) {
        if (board[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        dp[row][col] = Math.min(count, dp[row][col]);
        res = Math.max(res, dp[row][col]);
      }
    }
//    TwoDimensionArray.display2DimensionArray(dp);
    return res;
  }
}
