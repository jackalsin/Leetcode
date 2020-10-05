package tableau._529_Minesweeper;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
public final class DfsSolution implements Solution {
  private static final char UNREVEALED_MINE = 'M',
      UNREVEALED_EMPTY = 'E',
      REVEALED_MINE = 'X',
      REVEALED_BLANK = 'B';
  private int rows, cols;

  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 1},
      {1, -1}, {1, 0}, {1, 1},
  };

  public char[][] updateBoard(char[][] board, int[] click) {
    if (board == null || board.length == 0) {
      return board;
    }
    final int x = click[0], y = click[1];
    if (board[x][y] == UNREVEALED_MINE) {
      board[x][y] = REVEALED_MINE;
      return board;
    }
    rows = board.length;
    cols = board[0].length;
    dfs(board, x, y);
    return board;
  }

  private void dfs(final char[][] board, final int x, final int y) {
    if (!isValid(x, y) || board[x][y] != UNREVEALED_EMPTY) {
      return;
    }
    final char repr = getRepresent(board, x, y);
    board[x][y] = repr;
    if (repr == REVEALED_BLANK) {
      for (final int[] d : DIRS) {
        dfs(board, x + d[0], y + d[1]);
      }
    }
  }

  private char getRepresent(final char[][] board, final int x, final int y) {
    int count = 0;
    for (final int[] d : DIRS) {
      final int nextX = x + d[0], nextY = y + d[1];
      if (isValid(nextX, nextY) && board[nextX][nextY] == UNREVEALED_MINE) {
        count++;
      }
    }
    if (count == 0) {
      return REVEALED_BLANK;
    }
    return (char) (count + '0');
  }

  private boolean isValid(final int x, final int y) {
    return 0 <= x && x < rows && 0 <= y && y < cols;
  }
}
