package _651_700._659_Split_Array_into_Consecutive_Subsequences;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/28/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 2, 3, 4, 5, 6};
    assertTrue(solution.isPossible(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
    assertTrue(solution.isPossible(nums));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] nums = {1, 2, 3, 4, 4, 6};
    assertFalse(solution.isPossible(nums));
  }
}
