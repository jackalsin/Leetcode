package interviews.amazon._711_Number_of_Distinct_Islands_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water. Count the number of distinct islands. An island is considered to be the same
 * as another if they have the same shape, or have the same shape after rotation (90, 180, or 270
 * degrees only) or reflection (left/right direction or up/down direction).
 *
 * 127 ms
 * @author jacka
 * @version 1.0 on 10/25/2017.
 */
public class Solution {
  private static final int[][] DIRS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
  private static final int VISITED = -1;
  public int numDistinctIslands2(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length;
    if (grid[0].length == 0) {
      return 0;
    }
    final int cols = grid[0].length;
//    final boolean[][] visited = new boolean[rows][cols];
    final Set<List<Point>> islands = new HashSet<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 1) {
          final List<Point> island = new ArrayList<>();
          island.add(new Point(row, col));
          grid[row][col] = VISITED;
          dfs(grid, row, col, island);
          islands.add(norm(island));
        }
      }
    }
    return islands.size();
  }

  private List<Point> norm(List<Point> island) {
    List<List<Point>> allShapes = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      allShapes.add(new ArrayList<>());
    }
    for (Point p : island) {
      allShapes.get(0).add(new Point(p.x, p.y));
      allShapes.get(1).add(new Point(p.x, -p.y));
      allShapes.get(2).add(new Point(-p.x, p.y));
      allShapes.get(3).add(new Point(-p.x, -p.y));
      allShapes.get(4).add(new Point(p.y, p.x));
      allShapes.get(5).add(new Point(-p.y, p.x));
      allShapes.get(6).add(new Point(p.y, -p.x));
      allShapes.get(7).add(new Point(-p.y, -p.x));
    }
    for (List<Point> i : allShapes) {
      Collections.sort(i);
      Point base = i.get(0);
      for (int k = 1; k < i.size(); k++) {
        Point cur = i.get(k);
        i.set(k, new Point(cur.x - base.x, cur.y - base.y));
      }
      i.set(0, new Point(0, 0));
    }
    allShapes.sort(new Comparator<List<Point>>() {
      @Override
      public int compare(List<Point> o1, List<Point> o2) {
        if (o1.size() == o2.size()) {
          ListIterator<Point> itr1 = o1.listIterator();
          ListIterator<Point> itr2 = o2.listIterator();
          while (itr1.hasNext()) {
            final Point p1 = itr1.next();
            final Point p2 = itr2.next();
            if (!p1.equals(p2)) {
              return p1.compareTo(p2);
            }
          }
        }
        return Integer.compare(o1.size(), o2.size());
      }
    });

    return allShapes.get(0);
  }

  private void dfs(final int[][] grid, final int row, final int col, final List<Point> island) {
    final int rows = grid.length, cols = grid[0].length;
    for (int[] dir : DIRS) {
      final int nextRow = row + dir[0], nextCol = col + dir[1];
      if (nextCol >= 0 && nextCol < cols && nextRow >= 0 && nextRow < rows &&
          grid[nextRow][nextCol] == 1) {
        island.add(new Point(nextRow, nextCol));
        grid[nextRow][nextCol] = VISITED;
        dfs(grid, nextRow, nextCol, island);
      }
    }
  }

  private static final class Point implements Comparable<Point> {
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

    @Override
    public int compareTo(Point o) {
      if (x == o.x) {
        return Integer.compare(y, o.y);
      }
      return Integer.compare(x, o.x);
    }
  }
}
