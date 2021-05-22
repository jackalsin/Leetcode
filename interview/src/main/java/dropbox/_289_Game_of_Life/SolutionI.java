package dropbox._289_Game_of_Life;

/**
 * @author jacka
 * @version 1.0 on 5/22/2021
 */
public final class SolutionI implements Solution {
  private static final int LIVE = 1, DEAD = 0;
  private int rows, cols;

  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) return;
    rows = board.length;
    cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        final int lives = getLiveNeighbors(board, row, col);
        if ((board[row][col] & 0x1) == LIVE) {
          if (lives < 2) continue; // set 1st as 0
          else if (lives == 2 || lives == 3) {
            board[row][col] |= 0b10;
          } else {
            assert lives > 3;
            continue; // set 1st as 0
          }
        } else {
          if (lives == 3) {
            board[row][col] |= 0b10;
          }
        }
      }
    } // end of for row loop

    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        board[row][col] >>= 1;
      }
    }
  }

  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 1},
      {1, -1}, {1, 0}, {1, 1},
  };

  private int getLiveNeighbors(final int[][] board, final int row, final int col) {
    int count = 0;
    for (final int[] d : DIRS) {
      final int nextRow = d[0] + row,
          nextCol = d[1] + col;
      if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || (board[nextRow][nextCol] & 0x01) == 0)
        continue;
      count++;
    }
    return count;
  }
}
