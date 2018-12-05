package _0751_0800._799_Champagne_Tower;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private static final double BIAS = 1E-6;
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(0, solution.champagneTower(1, 1, 1), BIAS);
  }

  @Test
  void testOnlineCase2() {
    assertEquals(0.5, solution.champagneTower(2, 1, 1), BIAS);
  }

  @Test
  void testOnlineCase3() {
    assertEquals(1, solution.champagneTower(2, 0, 0), BIAS);
  }
}