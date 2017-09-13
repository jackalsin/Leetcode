package _301_350._305_Number_of_Islands_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class Solution {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    Set<Point> points = new HashSet<>();
    for (int[] coordinate: positions) {
      Point curPoint = new Point(coordinate[0], coordinate[1]);
      Point neighbor = null;

      curPoint.root = root(neighbor);
    }
    return new ArrayList<>();
  }

  private Point root(Point neighbor) {
    return null;
  }

  private static final class Point {
    final int x, y;
    Point root;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Point)) {
        return false;
      }
      Point that = (Point) o;
      return x == that.x && y == that.y && Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this);
    }

  }
}
