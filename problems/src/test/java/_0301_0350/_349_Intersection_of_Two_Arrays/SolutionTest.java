package _0301_0350._349_Intersection_of_Two_Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] nums1 = {1, 2, 2, 1};
    final int[] nums2 = {2, 2};
    final int[] expected = {2};
    assertArrayEquals(expected, solution.intersection(nums1, nums2));
  }

}
