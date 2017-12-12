package _501_550._503_Next_Greater_Element_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 2, 1};
    final int[] expected = {2, -1, 2};
    assertArrayEquals(expected, solution.nextGreaterElements(nums));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] nums = {};
    final int[] expected = {};
    assertArrayEquals(expected, solution.nextGreaterElements(nums));
  }
}