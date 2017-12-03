package _451_500._486_Predict_the_Winner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
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