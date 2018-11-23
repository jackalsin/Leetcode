package _0001_0050._004_Median_of_Two_Sorted_Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/8.
 */
public class SolutionTest {

  private final int[] nums1 = new int[]{1, 3, 5, 7};
  private final int[] nums2 = new int[]{2, 4, 6, 8};
  private final int[] nums3 = new int[]{3, 4, 5};
  private final int[] nums4 = new int[]{1, 2};

  private final int[] nums5 = new int[]{1, 2, 3};
  private final int[] nums6 = new int[]{4, 5};

  private final int[] nums7 = new int[0];
  private final int[] nums8 = new int[]{1};

  private final Solution solution = new Solution();

  @Test
  public void findMedianSortedArrays() throws Exception {
    assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), 1e-8);
  }

  @Test
  public void findMedianSortedArrays2() throws Exception {
    assertEquals(4d, solution.findMedianSortedArrays(nums3, nums2), 1e-8);
  }

  @Test
  public void findMedianSortedArrays3() throws Exception {
    assertEquals(3, solution.findMedianSortedArrays(nums3, nums4), 1e-8);
  }

  @Test
  public void findMedianSortedArrays4() throws Exception {
    assertEquals(3, solution.findMedianSortedArrays(nums5, nums6), 1e-8);
  }

  @Test
  public void findMedianSortedArrays5() throws Exception {
    assertEquals(1, solution.findMedianSortedArrays(nums7, nums8), 1e-8);
  }

  @Test
  public void findMedianSortedArrays6() throws Exception {
    int[] nums1 = new int[]{1, 2};
    int[] nums2 = new int[]{3, 4};
    assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 1e-8);
  }
}