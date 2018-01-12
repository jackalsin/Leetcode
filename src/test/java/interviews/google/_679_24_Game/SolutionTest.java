package interviews.google._679_24_Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/12/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {4, 1, 8, 7};
    assertTrue(solution.judgePoint24(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 1, 2};
    assertFalse(solution.judgePoint24(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {3, 3, 8, 8};
    assertTrue(solution.judgePoint24(nums));
  }
}
