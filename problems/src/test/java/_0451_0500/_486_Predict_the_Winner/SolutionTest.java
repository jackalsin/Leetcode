package _0451_0500._486_Predict_the_Winner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 5, 2};
    assertFalse(solution.PredictTheWinner(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 5, 233, 7};
    assertTrue(solution.PredictTheWinner(nums));
  }
}