package _451_500._487_Max_Consecutive_Ones_II;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/3/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(0, solution.findMaxConsecutiveOnes(new int[] {}));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] nums = {1, 0, 1, 1, 0};
    assertEquals(4, solution.findMaxConsecutiveOnes(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {0};
    assertEquals(1, solution.findMaxConsecutiveOnes(nums));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] nums = {0, 0, 0, 0};
    assertEquals(1, solution.findMaxConsecutiveOnes(nums));
  }

  @Test
  public void testFailedCase3() throws Exception {
    final int[] nums = {1, 1, 1, 1};
    assertEquals(4, solution.findMaxConsecutiveOnes(nums));
  }

  @Test
  public void testFailedCase4() throws Exception {
    final int[] nums = {1, 0, 1, 1, 1};
    assertEquals(5, solution.findMaxConsecutiveOnes(nums));
  }

  @Test
  public void testFailedCase5() throws Exception {
    final int[] nums = new int[10_000];
    Arrays.fill(nums, 1);
    nums[378] = 0;
    nums[1491] = 0;
    assertEquals(9621, solution.findMaxConsecutiveOnes(nums));
  }
}

