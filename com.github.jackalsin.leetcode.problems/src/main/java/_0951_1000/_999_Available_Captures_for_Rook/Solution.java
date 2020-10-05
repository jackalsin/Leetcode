package _0951_1000._999_Available_Captures_for_Rook;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
public class Solution {

  private static final char ROOK = 'R', EMPTY = '.', BISHOP = 'B', PAWN = 'p';
  private static final int ROWS = 8, COLS = 8;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int numRookCaptures(char[][] board) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (board[i][j] == ROOK) {
          int res = 0;
          for (int[] d : DIRS) {
            res += move(board, i, j, d);
          }
          return res;
        }
      }
    }
    throw new IllegalStateException("Not found rook");
  }

  private static int move(final char[][] board, final int startRow, final int startCol, int[] d) {
    for (int row = startRow, col = startCol; row < ROWS && col < COLS && row >= 0 && col >= 0; row += d[0], col += d[1]) {
      if (board[row][col] == EMPTY) continue;
      if (board[row][col] == PAWN) return 1;
      if (board[row][col] == BISHOP) return 0;
    }
    return 0; // reach the edge
  }

}
