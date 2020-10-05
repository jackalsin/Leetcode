package linkedin._215_Kth_Largest_Element_in_an_Array;

/**
 * This algorithm using mid as pivot value
 *
 * @author jacka
 * @version 1.0 on 7/8/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || k <= 0 || k > nums.length) {
      return -1;
    }
    return findKthLargest(nums, k, 0, nums.length - 1);
  }

  private static int findKthLargest(final int[] nums, final int k, final int start, final int end) {
    assert end >= start;
    if (start == end) {
      return nums[start];
    }
    final int mid = start + (end - start) / 2, midVal = nums[mid];
    int zero = start, one = start, second = end;
    while (one <= second) {
      if (nums[one] < midVal) {
        swap(nums, zero, one);
        zero++;
        one++;
      } else if (nums[one] == midVal) {
        one++;
      } else { // nums[one] > midVal
        swap(nums, one, second);
        second--;
      }
    }

    if (end - one + 1 >= k) {
      return findKthLargest(nums, k, one, end);
    } else if (end - zero + 1 >= k) {
      return midVal;
    } else {
      return findKthLargest(nums, k - (end - zero + 1), start, zero - 1);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
