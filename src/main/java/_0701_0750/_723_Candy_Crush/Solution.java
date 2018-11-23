package _0701_0750._723_Candy_Crush;

//import static utils.TwoDimensionArray.display;

public class Solution {

  private static final int[] HORIZONTAL = {0, 1}, VERTICAL = {1, 0};

  public int[][] candyCrush(int[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return board;
    }
    final int rows = board.length, cols = board[0].length;
    while (true) {
      boolean marked = false;
      for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
          if (board[row][col] == 0) continue;
          if (col + 2 < cols && isAbsEquals(board[row][col], board[row][col + 1])
              && isAbsEquals(board[row][col + 2], board[row][col + 1])) {
            dfs(board, row, col, HORIZONTAL);
            marked = true;
          }

          if (row + 2 < rows && isAbsEquals(board[row][col], board[row + 1][col])
              && isAbsEquals(board[row + 2][col], board[row + 1][col])) {
            dfs(board, row, col, VERTICAL);
            marked = true;
          }
        } // end of col
      } // end of row
      if (!marked) break;
//      display(board);

      final int[] distance = new int[rows];
      for (int row = rows - 1; row >= 0; --row) {
        for (int col = 0; col < cols; ++col) {
          if (board[row][col] <= 0) {
            distance[col]++;
          } else {
            board[row + distance[col]][col] = Math.abs(board[row][col]);
          } // end of else
          if (distance[col] != 0) {
            board[row][col] = 0;
          }
        }
      }

//      display(board);
//      System.out.println("==============================");
    }
    return board;
  }

  /**
   * Return coordinate
   *
   * @param board
   * @param startRow
   * @param startCol
   * @param dir
   */
  private static void dfs(final int[][] board, final int startRow, final int startCol, final int[] dir) {
    final int rows = board.length, cols = board[0].length;
    final int candy = Math.abs(board[startRow][startCol]);
    for (int row = startRow, col = startCol; row < rows && col < cols; row += dir[0], col += dir[1]) {
      if (candy == Math.abs(board[row][col])) {
        board[row][col] = -Math.abs(board[row][col]);
      } else {
        break;
      }
    }
  }

  private static boolean isAbsEquals(final int a, final int b) {
    if (a == Integer.MIN_VALUE) {
      return b == Integer.MIN_VALUE;
    }
    return Math.abs(a) == Math.abs(b);
  }
}
