package _1001_1050._1034_Coloring_A_Border;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class BfsSolution implements Solution {
  private int rows, cols;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    if (grid == null || grid.length == 0) {
      return grid;
    }
    rows = grid.length;
    cols = grid[0].length;
    final Queue<int[]> q = new ArrayDeque<>();
    final Set<Long> visited = new HashSet<>();
    final List<int[]> border = new ArrayList<>();
    final long pos = getPos(r0, c0);
    q.add(new int[]{r0, c0});
    visited.add(pos);
    while (!q.isEmpty()) {
      final int[] toRemove = q.remove();
      final int row = toRemove[0];
      final int col = toRemove[1];
      for (final int[] dir : DIRS) {
        final int nextRow = dir[0] + toRemove[0], nextCol = dir[1] + toRemove[1];
        final long nextPos = getPos(nextRow, nextCol);
        if (isInRange(nextRow, nextCol) && grid[nextRow][nextCol] == grid[r0][c0]) {
          if (!visited.contains(nextPos)) {
            q.add(new int[]{nextRow, nextCol});
            visited.add(nextPos);
          }
        } else {
          border.add(new int[]{row, col});
        }
      }
    }
    // update the border
    for (final int[] b : border) {
      grid[b[0]][b[1]] = color;
    }
    return grid;
  }

  private long getPos(final int r0, final int c0) {
    return (((long) r0) << 32) | c0;
  }

  private boolean isInRange(final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
