package _0301_0350._350_Intersection_of_Two_Arrays_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] nums1 = {1, 2, 2, 1};
    final int[] nums2 = {2, 2};
    final int[] expected = {2, 2};
    assertArrayEquals(expected, solution.intersect(nums1, nums2));
  }

}
