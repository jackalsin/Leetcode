package _451_500._494_Target_Sum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DfsSolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new DfsSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 1, 1, 1, 1};
    assertEquals(5, solution.findTargetSumWays(nums, 3));
  }
}