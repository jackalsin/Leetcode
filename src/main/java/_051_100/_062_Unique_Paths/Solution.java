package _051_100._062_Unique_Paths;

/**
 * @author jacka
 * @version 1.0 on 4/23/2017.
 */
public class Solution {
  public int uniquePaths(int m, int n) {
    int[][] board = new int[m][n];
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row == 0) {
          board[row][col] = 1;
        } else if (col == 0) {
          board[row][col] = 1;
        } else {
          board[row][col] = board[row - 1][col] + board[row][col - 1];
        }
      }
    }
    return board[m - 1][n - 1];
  }
}
