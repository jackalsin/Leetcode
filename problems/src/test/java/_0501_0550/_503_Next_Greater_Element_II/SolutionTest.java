package _0501_0550._503_Next_Greater_Element_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SolutionTest {
  private Solution solution;

  @BeforeEach
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