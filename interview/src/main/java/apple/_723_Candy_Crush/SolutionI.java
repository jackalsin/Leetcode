package apple._723_Candy_Crush;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
public final class SolutionI implements Solution {

  public int[][] candyCrush(int[][] board) {
    int rows = board.length, cols = board[0].length;
    boolean isStable = false;
    while (!isStable) {
      isStable = true;
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          final int val = Math.abs(board[row][col]);
          if (val == 0) continue;
          if (row < rows - 2 && Math.abs(board[row + 1][col]) == val && val == Math.abs(board[row + 2][col])) {
            isStable = false;
            board[row][col] = board[row + 1][col] = board[row + 2][col] = -val;
          }
          if (col < cols - 2 && val == Math.abs(board[row][col + 1]) && val == Math.abs(board[row][col + 2])) {
            isStable = false;
            board[row][col] = board[row][col + 1] = board[row][col + 2] = -val;
          }
        }
      } // end of for
      if (!isStable) {
        for (int col = 0; col < cols; ++col) {
          int end = rows - 1;
          for (int row = rows - 1; row >= 0; row--) {
            if (board[row][col] > 0) {
              board[end--][col] = board[row][col];
            }
          } // end of for row
          for (; end >= 0; end--) {
            board[end][col] = 0;
          }
        }
      }
//      TwoDimensionArray.println(board);
    }
    return board;
  }

}
