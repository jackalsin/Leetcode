package _0651_0700._688_Knight_Probability_in_Chessboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;
  private static final double BIAS = 1E-4;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(0.0625, solution.knightProbability(3, 2, 0, 0), BIAS);
  }

  @Test
  void testOnlineCase2() {
    assertEquals(0.00019, solution.knightProbability(8, 30, 6, 4), BIAS);
  }

  @Test
  void testFailedCase1() {
    assertEquals(1, solution.knightProbability(1, 0, 0, 0), BIAS);
  }
}