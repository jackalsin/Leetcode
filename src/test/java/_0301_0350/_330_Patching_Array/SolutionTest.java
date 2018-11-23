package _0301_0350._330_Patching_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/30/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] nums = {1, 2, 4, 13, 43};
    final int n = 100;
    assertEquals(2, solution.minPatches(nums, n));
  }

}
