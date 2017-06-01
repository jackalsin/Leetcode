package _051_100._088_Merge_Sorted_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/28/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testBothFinish() throws Exception {
    final int[] nums1 = new int[] {1, 3, 5, 0, 0, 0};
    final int[] nums2 = new int[] {2, 4, 6};
    solution.merge(nums1, 3, nums2, 3);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
  }

  @Test
  public void test1FinishFirst() throws Exception{
    final int[] nums1 = new int[]{1, 0, 0, 0};
    final int[] nums2 = new int[]{-1, 2, 4};
    final int[] expected = new int[]{-1, 1, 2, 4};
    solution.merge(nums1,1, nums2, 3);
    assertArrayEquals(expected, nums1);
  }

  @Test
  public void test2FinishFirst() throws Exception{
    final int[] nums1 = new int[]{1, 3, 4, 0};
    final int[] nums2 = new int[]{2};
    final int[] expected = new int[]{1, 2, 3, 4};
    solution.merge(nums1,3, nums2, 1);
    assertArrayEquals(expected, nums1);
  }
}