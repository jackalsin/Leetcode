package _0451_0500._478_Generate_Random_Point_in_a_Circle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class SolutionTest {
  private static final int N = 1_000_000;

  @Test
  void testOnlineCase1() {
    final double r = 0.01, x = -73839.1, y = -3289891.3;
    final Solution solution = new Solution(r, x, y);
    for (int i = 0; i < N; i++) {
      final double[] point = solution.randPoint();
      final double distance = (point[0] - x) * (point[0] - x) + (point[1] - y) * (point[1] - y);
      assertTrue(r * r >= distance);
    }
  }
}