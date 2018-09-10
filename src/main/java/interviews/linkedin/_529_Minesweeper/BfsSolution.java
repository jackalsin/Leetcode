package interviews.linkedin._529_Minesweeper;

import java.util.*;

public final class BfsSolution implements Solution {

  private static final char U_EMPTY = 'E', U_MINE = 'M',
      R_EMPTY = 'B', R_MINE = 'X';

  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0},
      {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
  };

  public char[][] updateBoard(char[][] board, int[] click) {
    if (board == null || board.length == 0) {
      return board;
    }
    final int rows = board.length, cols = board[0].length;
    if (board[click[0]][click[1]] == U_MINE) {
      board[click[0]][click[1]] = R_MINE;
      return board;
    }
    final Queue<int[]> q = new ArrayDeque<>();
    final Set<Point> visited = new HashSet<>();
    q.add(click);
    board[click[0]][click[1]] = R_EMPTY;

    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int row = toRemove[0], col = toRemove[1];

      updateMineNumber(board, row, col);

      final char chr = board[row][col];
      if (Character.isDigit(chr)) {
        continue;
      }

      for (final int[] dir : DIRS) {
        final int nextRow = row + dir[0], nextCol = col + dir[1];
        if (isValid(board, nextRow, nextCol) && board[nextRow][nextCol] == U_EMPTY
            && !visited.contains(new Point(nextRow, nextCol))) {
          q.add(new int[]{nextRow, nextCol});
          visited.add(new Point(nextRow, nextCol));
        }
      }
    }

    return board;
  }

  private static void updateMineNumber(char[][] board, int row, int col) {
    int mines = 0;
    for (final int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (isValid(board, nextRow, nextCol) && board[nextRow][nextCol] == U_MINE) {
        mines++;
      }
    }
    board[row][col] = mines > 0 ? (char) ('0' + mines) : R_EMPTY;
  }


  private static boolean isValid(final char[][] board, final int row, final int col) {
    final int rows = board.length, cols = board[0].length;
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static final class Point {
    private final int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
