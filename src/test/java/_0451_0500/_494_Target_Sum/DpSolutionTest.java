package _0451_0500._494_Target_Sum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DpSolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new DpSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 1, 1, 1, 1};
    assertEquals(5, solution.findTargetSumWays(nums, 3));
  }

  /**
   * It throws the memory exceed limit error
   *
   * @throws Exception
   */
  @Test
  public void testFailedOnLargerTargetSum() {
    final int[] nums = {1, 2, 7, 9, 981};
    assertEquals(0, solution.findTargetSumWays(nums, 1000000000));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
    assertEquals(256, solution.findTargetSumWays(nums, 1));
  }
}