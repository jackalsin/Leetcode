package oracle.flowFree;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/5/2019
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };
  private static final int UNVISITED = -1;

  @Override
  public int[][] solve(int size, int[][][] points) {
    if (size < 0) {
      throw new IllegalArgumentException();
    }
    if (points == null || points.length == 0) {
      throw new IllegalArgumentException();
    }
    final int[][] board = getBoard(size);

    // mark start point
    for (int i = 0; i < points.length; i++) {
      final int[][] pair = points[i];
      assert pair.length == 2;
      for (final int[] p : pair) {
        board[p[0]][p[1]] = i;
      }
    }

    if (!solve(board, points, 0, points[0][0], points[0][1])) {
      return null;
    }
    return board;
  }

  private boolean solve(final int[][] board, final int[][][] p, final int i, final int[] start, final int[] end) {
    final int size = board.length;
    // mark it
    for (final int[] dir : DIRS) {
      final int nextRow = start[0] + dir[0], nextCol = start[1] + dir[1];
      if (nextRow == end[0] && nextCol == end[1]) {
        if (i == p.length - 1) {
          return true;
        }
        return solve(board, p, i + 1, p[i + 1][0], p[i + 1][1]);
      }
      if (isValid(size, nextRow, nextCol) && board[nextRow][nextCol] == UNVISITED) {
        board[nextRow][nextCol] = i;
        if (solve(board, p, i, new int[]{nextRow, nextCol}, p[i][1])) {
          return true;
        }
        board[nextRow][nextCol] = UNVISITED;
      }
    }
    return false;
  }

  private static boolean isValid(final int size, final int row, final int col) {
    return 0 <= row && row < size && 0 <= col && col < size;
  }

  private static int[][] getBoard(final int size) {
    final int[][] board = new int[size][size];
    for (final int[] row : board) {
      Arrays.fill(row, UNVISITED);
    }
    return board;
  }
}
