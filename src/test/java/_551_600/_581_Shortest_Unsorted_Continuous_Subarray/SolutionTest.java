package _551_600._581_Shortest_Unsorted_Continuous_Subarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {2, 6, 4, 8, 10, 9, 15};
    assertEquals(5, solution.findUnsortedSubarray(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {1};
    assertEquals(0, solution.findUnsortedSubarray(nums));
  }
}
