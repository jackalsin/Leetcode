package uber._486_Predict_the_Winner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {1, 5, 2};
    assertFalse(solution.PredictTheWinner(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {1, 5, 233, 7};
    assertTrue(solution.PredictTheWinner(input));
  }
}