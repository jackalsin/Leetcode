package _0301_0350._334_Increasing_Triplet_Subsequence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/2/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = {1, 2, 3, 4, 5};
    assertTrue(solution.increasingTriplet(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = {5, 4, 3, 2, 1};
    assertFalse(solution.increasingTriplet(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] input = {5, 1, 5, 5, 2, 5, 4};
    assertTrue(solution.increasingTriplet(input));
  }

  @Test
  public void testFailedTestCase() throws Exception {
    final int[] input = {2, 1, 5, 0, 3};
    assertFalse(solution.increasingTriplet(input));
  }
}
