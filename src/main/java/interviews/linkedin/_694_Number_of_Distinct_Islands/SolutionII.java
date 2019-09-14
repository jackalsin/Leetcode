package interviews.linkedin._694_Number_of_Distinct_Islands;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/13/2019
 */
public final class SolutionII implements Solution {
  private int rows, cols;

  public int numDistinctIslands(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final Set<Set<Point>> islands = new HashSet<>();
    rows = grid.length;
    cols = grid[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          final Set<Point> island = new HashSet<>();
          dfs(grid, island, row, col, row, col);
          islands.add(island);
        }
      }
    }

    return islands.size();
  }

  private void dfs(final int[][] grid, final Set<Point> island,
                   final int startRow, final int startCol, final int row, final int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
      return;
    }
    grid[row][col] = 0;
    final int x = row - startRow, y = col - startCol;
    island.add(Point.of(x, y));
    dfs(grid, island, startRow, startCol, row + 1, col);
    dfs(grid, island, startRow, startCol, row - 1, col);
    dfs(grid, island, startRow, startCol, row, col + 1);
    dfs(grid, island, startRow, startCol, row, col - 1);
  }

  private static final class Point {
    private final int x, y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Point)) return false;
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    private static Point of(final int x, final int y) {
      return new Point(x, y);
    }
  }
}
