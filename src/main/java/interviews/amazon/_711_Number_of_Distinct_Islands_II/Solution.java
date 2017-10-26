package interviews.amazon._711_Number_of_Distinct_Islands_II;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water. Count the number of distinct islands. An island is considered to be the same
 * as another if they have the same shape, or have the same shape after rotation (90, 180, or 270
 * degrees only) or reflection (left/right direction or up/down direction).
 *
 * @author jacka
 * @version 1.0 on 10/25/2017.
 */
public class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

  public int numDistinctIslands2(int[][] grid) {
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
    int count = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1 && !visited[row][col]) {
          final Point leftTop = new Point(row, col);
          final Island island = new Island();
          island.points.add(new Point(0, 0));
          visited[row][col] = true;
          dfs(grid, visited, leftTop, row, col, island);
          if (!islands.contains(island)) {
            count++;
            final IslandGroupBuilder builder = new IslandGroupBuilder(island);
            islands.addAll(builder.build());
          }
        }
      }
    }
    return count;
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

  private static final class IslandGroupBuilder {
    private final Set<Island> allShapes;
    private final Island baseIsland;
    private int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MAX_VALUE,
        bottom = Integer.MIN_VALUE;

    public IslandGroupBuilder(final Island baseIsland) {
      this.allShapes = new HashSet<>();
      this.baseIsland = baseIsland;
      updateBoundary();
    }

    private void updateBoundary() {
      for (Point point : baseIsland.points) {
        left = Math.min(point.x, left);
        right = Math.max(point.x, right);
        top = Math.min(top, point.y);
        bottom = Math.max(point.y, bottom);
      }
    }

    public Set<Island> build() {
      final int xSum = left + right, ySum = top + bottom;
      allShapes.add(baseIsland);
      allShapes.addAll(xyReflection(xSum, ySum, baseIsland)); // + x reflect + y reflect;
      allShapes.addAll(rotation(xSum, ySum, baseIsland)); // 90, 180, 270
      return allShapes;
    }

    private Collection<Island> rotation(final int xSum, final int ySum, final Island baseIsland) {
      final Island island2 = new Island();
      final Island island3 = new Island();
      final Island island4 = new Island();
      final List<Island> islands = new ArrayList<>();
      for (Point p : baseIsland.points) {
        island2.points.add(
            new Point((ySum + xSum - 2 * p.y) / 2, (ySum + xSum - 2 * p.x) / 2));
        island3.points.add(new Point(xSum - p.x, ySum - p.y));
        island4.points.add(new Point((-ySum + xSum + 2 * p.y) / 2, (ySum - xSum + 2 * p.x) / 2));
      }
      islands.add(island2);
      islands.add(island3);
      islands.add(island4);
      return islands;
    }

    private Collection<Island> xyReflection(final int xSum, final int ySum, final Island
        baseIsland) {
      final Island xReflected = new Island();
      final Island yReflected = new Island();
      for (Point p : baseIsland.points) {
        xReflected.points.add(new Point(xSum - p.x, p.y));
        yReflected.points.add(new Point(p.x, ySum - p.y));
      }
      final List<Island> result = new ArrayList<>();
      result.add(xReflected);
      result.add(yReflected);
      return result;
    }
  }

  private static final class Island {
    private final Set<Point> points;

    private Island() {
      points = new HashSet<>();
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
