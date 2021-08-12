package _0301_0350._321_Create_Maximum_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 9/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline1() throws Exception {
    final int[] nums1 = {3, 4, 6, 5};
    final int[] nums2 = {9, 1, 2, 5, 8, 3};
    final int[] expected = {9, 8, 6, 5, 3};
    assertArrayEquals(expected, solution.maxNumber(nums1, nums2, 5));
  }

  @Test
  public void testOnline2() throws Exception {
    final int[] nums1 = {6, 7};
    final int[] nums2 = {6, 0, 4};
    final int[] expected = {6, 7, 6, 0, 4};
    assertArrayEquals(expected, solution.maxNumber(nums1, nums2, 5));
  }

  @Test
  public void testOnline3() throws Exception {
    final int[] nums1 = {3, 9};
    final int[] nums2 = {8, 9};
    final int[] expected = {9, 8, 9};
    assertArrayEquals(expected, solution.maxNumber(nums1, nums2, 3));
  }

}
