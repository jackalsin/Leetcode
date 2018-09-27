package interviews.linkedin._529_Minesweeper;

import java.util.*;

public final class BfsSolution implements Solution {
  private static final char U_MINE = 'M', R_MINE = 'X', U_EMPTY = 'E', R_EMPTY = 'B';
  private static int[][] DIRS = {
      {-1, -1}, {0, -1}, {1, -1},
      {-1, 0}, {1, 0},
      {-1, 1}, {0, 1}, {1, 1},
  };

  @Override
  public char[][] updateBoard(char[][] board, int[] click) {
    if (board == null || board.length == 0) {
      return board;
    }
    final int rows = board.length, cols = board[0].length, clickRow = click[0], clickCol = click[1];

    if (board[clickRow][clickCol] == U_MINE) {
      board[clickRow][clickCol] = R_MINE;
      return board;
    }
    final Set<Point> visited = new HashSet<>();
    final Queue<Point> q = new ArrayDeque<>();
    final Point start = new Point(clickRow, clickCol);
    q.add(start);
    visited.add(start); // already queued
    board[clickRow][clickCol] = R_EMPTY;
    while (!q.isEmpty()) {
      final Point toRemove = q.remove();
      final int startRow = toRemove.x, startCol = toRemove.y;
      updateMineNumber(board, startRow, startCol);
      if (Character.isDigit(board[startRow][startCol])) continue;

      for (final int[] dir : DIRS) {
        final int nextRow = dir[0] + startRow, nextCol = dir[1] + startCol;
        if (!isValid(nextRow, nextCol, rows, cols)) continue;
        final Point nextPoint = new Point(nextRow, nextCol);
        if (visited.contains(nextPoint)) continue;
        visited.add(nextPoint);
        q.add(nextPoint);
      }
    }
    return board;
  }

  private void updateMineNumber(final char[][] board, final int startRow, final int startCol) {
    final int rows = board.length, cols = board[0].length;
    int count = 0;
    for (final int[] dir : DIRS) {
      final int nextRow = startRow + dir[0], nextCol = startCol + dir[1];
      if (!isValid(nextRow, nextCol, rows, cols)) {
        continue;
      }
      if (board[nextRow][nextCol] == U_MINE) {
        count++;
      }
    }

    board[startRow][startCol] = count > 0 ? (char) ('0' + count) : R_EMPTY;
  }

  private static boolean isValid(final int r, final int c, final int rows, final int cols) {
    return 0 <= r && r < rows && 0 <= c && c < cols;
  }


  private static final class Point {
    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }

      if (!(o instanceof Point)) {
        return false;
      }

      Point that = (Point) o;
      return that.x == x && that.y == y;
    }
  }
}
