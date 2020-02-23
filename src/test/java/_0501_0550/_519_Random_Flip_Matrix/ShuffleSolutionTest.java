package _0501_0550._519_Random_Flip_Matrix;

import org.junit.jupiter.api.Test;
import utils.Point;
import utils.TwoDimensionArray;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShuffleSolutionTest {
  @Test
  void testOnlineCase1() {
    final int n_rows = 2, n_cols = 3;
    final Solution solution = new ShuffleSolution(2, 3);
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

  @Test
  void testUniformlyDistributed() {
    final int n_rows = 2, n_cols = 3, count = 10_000;
    final ShuffleSolution solution = new ShuffleSolution(2, 3);
    final int[][] counts = new int[n_rows * n_cols][n_rows * n_cols];
    for (int i = 0; i < count; ++i) {
      solution.reset();
      final int[] vals = solution.getVal();
      for (int j = 0; j < vals.length; ++j) {
        counts[vals[j]][j]++;
      }
    }

    TwoDimensionArray.toString(counts);

  }
}