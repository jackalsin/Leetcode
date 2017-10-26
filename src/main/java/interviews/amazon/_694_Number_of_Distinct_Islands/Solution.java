package interviews.amazon._694_Number_of_Distinct_Islands;

import java.util.HashSet;
import java.util.Set;

/**
 * * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water.
 *
 * Count the number of <strong>distinct islands</strong>. An island is considered to be the same as
 * another if and only if one island can be translated (and not rotated or reflected) to equal the
 * other.
 *
 * @author jacka
 * @version 1.0 on 10/25/2017.
 */
public class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

  public int numDistinctIslands(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length;
    if (grid[0].length == 0) {
      return 0;
    }
    final int cols = grid[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    final Set<Island> islands = new HashSet<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1 && !visited[row][col]) {
          final Point leftTop = new Point(row, col);
          final Island island = new Island();
          visited[row][col] = true;
          dfs(grid, visited, leftTop, row, col, island);
          islands.add(island);
        }
      }
    }
    return islands.size();
  }

  private void dfs(final int[][] grid, final boolean[][] visited, final Point base,
                   final int row, final int col, final Island island) {
    final int rows = visited.length, cols = visited[0].length;
    for (int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (nextCol >= 0 && nextCol < cols && nextRow >= 0 && nextRow < rows &&
          !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
        visited[nextRow][nextCol] = true;
        island.points.add(new Point(nextRow - base.x, nextCol - base.y));
        dfs(grid, visited, base, nextRow, nextCol, island);
      }
    }
  }

  private static final class Island {
    private final Set<Point> points;

    private Island() {
      points = new HashSet<>();
      points.add(new Point(0, 0));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Island)) {
        return false;
      }

      Island island = (Island) o;

      return points.equals(island.points);
    }

    @Override
    public int hashCode() {
      return points.hashCode();
    }
  }

  private static final class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Point)) {
        return false;
      }

      Point point = (Point) o;

      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }

    @Override
    public String toString() {
      return "(" +
          "x=" + x +
          ", y=" + y +
          ')';
    }
  }

}
