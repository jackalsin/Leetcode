package _501_550._519_Random_Flip_Matrix;

import org.junit.jupiter.api.Test;
import utils.Point;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VirtualArraySolutionTest {
  @Test
  void testOnlineCase1() {
    final int n_rows = 2, n_cols = 3;
    final Solution solution = new VirtualArraySolution(2, 3);
    final Set<Point> points = new HashSet<>();
    for (int i = 0; i < n_rows * n_cols; ++i) {
      final int[] p = solution.flip();
      points.add(new Point(p[0], p[1]));
    }

    assertEquals(6, points.size());
    for (int r = 0; r < n_rows; r++) {
      for (int c = 0; c < n_cols; c++) {
        final Point p = new Point(r, c);
        assertTrue(points.contains(p));
      }
    }
  }

}