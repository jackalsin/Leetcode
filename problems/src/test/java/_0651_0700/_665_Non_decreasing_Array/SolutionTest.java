package _0651_0700._665_Non_decreasing_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {4, 2, 3};
    assertTrue(solution.checkPossibility(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {4, 2, 1};
    assertFalse(solution.checkPossibility(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {3, 4, 2, 3};
    assertFalse(solution.checkPossibility(nums));
  }
}
