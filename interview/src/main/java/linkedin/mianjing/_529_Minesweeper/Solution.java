package linkedin.mianjing._529_Minesweeper;

import java.util.*;

public class Solution {
  private static final char U_MINE = 'M', R_MINE = 'X', U_BLANK = 'E',
      R_BLANK = 'B';
  private static final int[][] DIRS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 1},
      {1, -1}, {1, 0}, {1, 1},

  };

  public char[][] updateBoard(char[][] board, int[] click) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return board;
    }

    final int rows = board.length, cols = board[0].length;
    if (board[click[0]][click[1]] == U_MINE) {
      board[click[0]][click[1]] = R_MINE;
      return board;
    }
    final Queue<Point> q = new ArrayDeque<>();
    final Point startPoint = new Point(click[0], click[1]);
    q.add(startPoint);
    final Set<Point> queued = new HashSet<>();
    queued.add(startPoint);
    while (!q.isEmpty()) {
      final Point toRemove = q.remove();
      final int row = toRemove.x, col = toRemove.y;
      updateMineNumbers(board, rows, cols, toRemove.x, toRemove.y);
      if (Character.isDigit(board[row][col])) continue;
      for (int[] dir : DIRS) {
        final int nextRow = row + dir[0], nextCol = col + dir[1];
        if (!isValid(rows, cols, nextRow, nextCol)) {
          continue;
        }
        final Point nextPoint = new Point(nextRow, nextCol);
        if (!queued.contains(nextPoint)) {
          queued.add(nextPoint);
          q.add(nextPoint);
        }
      }

    }
    return board;
  }

  private static boolean isValid(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static void updateMineNumbers(final char[][] board, final int rows, final int cols, final int startRow
      , final int startCol) {
    int count = 0;
    for (int[] dir : DIRS) {
      final int r = dir[0] + startRow, c = startCol + dir[1];
      if (!isValid(rows, cols, r, c)) continue;
      if (board[r][c] == U_MINE) {
        count++;
      }
    }
    board[startRow][startCol] = count == 0 ? R_BLANK : (char) ('0' + count);

  }

  private static final class Point {
    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
      if (!(o instanceof Point)) {
        return false;
      }
      final Point p = (Point) o;
      return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
