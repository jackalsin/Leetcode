package interviews.linkedin._529_Minesweeper;

public final class DfsSolution implements Solution {
  private static final char U_MINE = 'M', R_MINE = 'X',
      U_EMPTY = 'E', R_EMPTY = 'B';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
      {-1, 1}, {-1, -1}, {1, 1}, {1, -1}
  };

  @Override
  public char[][] updateBoard(char[][] board, int[] click) {
    if (board == null || board.length == 0) {
      return board;
    } else if (board[click[0]][click[1]] == U_MINE) {
      board[click[0]][click[1]] = R_MINE;
      return board;
    }
    final int rows = board.length, cols = board[0].length;
    dfs(board, rows, cols, click[0], click[1]);
    return board;
  }

  private static void dfs(final char[][] board, final int rows, final int cols, final int row, final int col) {
    updateMine(board, row, col);
    if (Character.isDigit(board[row][col])) return;
    for (final int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (isValid(rows, cols, nextRow, nextCol) && board[nextRow][nextCol] == U_EMPTY) {
        dfs(board, rows, cols, nextRow, nextCol);
      }
    }
  }

  private static void updateMine(final char[][] board, final int row, final int col) {
    int mine = 0;
    final int rows = board.length, cols = board[0].length;
    for (final int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (isValid(rows, cols, nextRow, nextCol) && board[nextRow][nextCol] == U_MINE) {
        mine++;
      }
    }
    board[row][col] = mine > 0 ? (char) ('0' + mine) : R_EMPTY;
  }


  private static boolean isValid(final int rows, final int cols, int row, int col) {
    return 0 <= col && col < cols && 0 <= row && row < rows;
  }
}
