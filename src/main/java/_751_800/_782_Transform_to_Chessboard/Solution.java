package _751_800._782_Transform_to_Chessboard;

/**
 * @author jacka
 * @version 1.0 on 3/8/2018.
 */
public class Solution {
  /**
   * Time Complexity: o(N)
   */
  public int movesToChessboard(int[][] board) {
    final int rows = board.length, cols = board[0].length;
    // check there are only 2 kinds of rows and cols
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if ((board[0][0] ^ board[0][col] ^ board[row][0] ^ board[row][col]) == 1) {
          return -1;
        }
      }
    }

    int rowSum = 0, colSum = 0, colNeedSwap = 0, rowNeedSwap = 0;
    for (int i = 0; i < rows; i++) {
      rowSum += board[i][0];
      colSum += board[0][i];
      if (board[0][i] == i % 2) {
        colNeedSwap++;
      }
      if (board[i][0] == i % 2) {
        rowNeedSwap++;
      }
    }

    if (rowSum < rows / 2 || rowSum > (rows + 1) / 2 || colSum < cols / 2 || colSum > (cols + 1) / 2) {
      return -1;
    }

    if (rows % 2 == 1) {
      if (colNeedSwap % 2 == 1) {
        colNeedSwap = rows - colNeedSwap;
      }
      if (rowNeedSwap % 2 == 1) {
        rowNeedSwap = rows - rowNeedSwap;
      }
    } else {
      colNeedSwap = Math.min(colNeedSwap, rows - colNeedSwap);
      rowNeedSwap = Math.min(rowNeedSwap, rows - rowNeedSwap);
    }

    return (rowNeedSwap + colNeedSwap) / 2;
  }
}
