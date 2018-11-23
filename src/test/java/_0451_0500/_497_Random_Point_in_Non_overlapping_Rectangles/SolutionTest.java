package _0451_0500._497_Random_Point_in_Non_overlapping_Rectangles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.TwoDimensionArray.display;

class SolutionTest {
  private Solution solution;
  private static final int MAX_COUNT = 10_000_000;
  private static final double BIAS = 1E-3;

  @Test
  void testOnlineCase1() {
    final int[][] rects = {{1, 1, 5, 5}};
    solution = new Solution(rects);
    final int[][] p = new int[6][6];
    for (int i = 0; i < MAX_COUNT; ++i) {
      final int[] rect = solution.pick();
      p[rect[0]][rect[1]]++;
    }

    for (int row = 1; row <= 5; row++) {
      for (int col = 1; col <= 5; col++) {
        assertEquals(1d / 25, p[row][col] / (double) MAX_COUNT, BIAS);
      }
    }
    display(p);
  }

}