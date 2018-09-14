package _501_550._528_Random_Pick_with_Weight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
class SolutionTest {
  private static final int MAX_COUNT = 10_000_000;

  private static final double BIAS = 1e-2;

  @Test
  void testOnlineCase1() {
    final int w1 = 10, w2 = 15;
    final int[] w = {w1, w2};
    final Solution solution = new Solution(w);
    final int[] count = new int[2];
    for (int i = 0; i < MAX_COUNT; ++i) {
      final int res = solution.pickIndex();
      count[res]++;
    }
    assertEquals((double) w1 / (double) w2, (double) count[0] / (double) count[1], BIAS);
  }

}