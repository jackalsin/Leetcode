package google._723_Candy_Crush;

/**
 * @author jacka
 * @version 1.0 on 4/27/2021
 */
public final class SolutionI implements Solution {
  public int[][] candyCrush(int[][] board) {
    if (board == null || board.length == 0) return board;
    final int rows = board.length, cols = board[0].length;
    boolean isStable = false;
    while (!isStable) {
      isStable = true;
      for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
          final int val = Math.abs(board[i][j]);
          if (val == 0) continue;
          if (0 < j && j < cols - 1 && absEquals(board[i][j], board[i][j + 1], board[i][j - 1])) { // horizontal
            isStable = false;
            board[i][j - 1] = board[i][j] = board[i][j + 1] = -val;
          }

          if (0 < i && i < rows - 1 && absEquals(board[i - 1][j], board[i][j], board[i + 1][j])) {
            isStable = false;
            board[i - 1][j] = board[i][j] = board[i + 1][j] = -val;
          }
        }
      } // end for loop out
      final int[] distances = new int[cols];
      for (int row = rows - 1; row >= 0; row--) {
        for (int col = 0; col < cols; ++col) {
          if (board[row][col] <= 0) {
            board[row][col] = 0;
            distances[col]++;
          } else {
            board[row + distances[col]][col] = board[row][col];
            if (distances[col] != 0) {
              board[row][col] = 0;
            }
          }
        }
      }
    }
    return board;
  }

  private static boolean absEquals(final int i, final int j, final int k) {
    return Math.abs(i) == Math.abs(j) && Math.abs(j) == Math.abs(k);
  }
}
