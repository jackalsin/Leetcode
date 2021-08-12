package airbnb._088_Merge_Sorted_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 1/23/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testBothFinish() throws Exception {
    final int[] nums1 = new int[]{1, 3, 5, 0, 0, 0};
    final int[] nums2 = new int[]{2, 4, 6};
    solution.merge(nums1, 3, nums2, 3);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
  }

  @Test
  void test1FinishFirst() throws Exception {
    final int[] nums1 = new int[]{1, 0, 0, 0};
    final int[] nums2 = new int[]{-1, 2, 4};
    final int[] expected = new int[]{-1, 1, 2, 4};
    solution.merge(nums1, 1, nums2, 3);
    assertArrayEquals(expected, nums1);
  }

  @Test
  void test2FinishFirst() throws Exception {
    final int[] nums1 = new int[]{1, 3, 4, 0};
    final int[] nums2 = new int[]{2};
    final int[] expected = new int[]{1, 2, 3, 4};
    solution.merge(nums1, 3, nums2, 1);
    assertArrayEquals(expected, nums1);
  }
}