package _0701_0750._747_Largest_Number_At_Least_Twice_of_Others;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {3, 6, 1, 0};
    assertEquals(1, solution.dominantIndex(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 3, 4};
    assertEquals(-1, solution.dominantIndex(nums));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {1};
    assertEquals(0, solution.dominantIndex(nums));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final int[] nums = {0, 0, 3, 2};
    assertEquals(-1, solution.dominantIndex(nums));
  }

  @Test
  public void testFailedCase3() {
    final int[] nums = {1, 0};
    assertEquals(0, solution.dominantIndex(nums));
  }
}