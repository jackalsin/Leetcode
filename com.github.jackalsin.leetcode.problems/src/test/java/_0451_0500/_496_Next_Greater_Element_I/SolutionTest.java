package _0451_0500._496_Next_Greater_Element_I;

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
    final int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2}, expected = {-1, 3, -1};
    assertArrayEquals(expected, solution.nextGreaterElement(nums1, nums2));
  }
}