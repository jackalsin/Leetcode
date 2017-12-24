package _601_650._643_Maximum_Average_Subarray_I;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private static final double DELTA = 1E-7;
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 12, -5, -6, 50, 3};
    final int k = 4;
    assertEquals(12.75, solution.findMaxAverage(nums, k), DELTA);
  }
}