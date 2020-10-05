package linkedin._215_Kth_Largest_Element_in_an_Array;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || k < 0) {
      return -1;
    }
    return findKthLargest(nums, k, 0, nums.length - 1);
  }

  private static int findKthLargest(final int[] nums, final int k, final int left, int right) {
    assert left <= right;
    if (left == right) {
      return nums[left];
    }
    final int pivotValue = nums[right];
    int pivotIndex = left;
    for (int i = left; i < right; ++i) {
      if (nums[i] <= pivotValue) {
        swap(nums, i, pivotIndex++);
      }
    }
    swap(nums, pivotIndex, right);
    // pivot index points
    // <= pi
    if (right - pivotIndex + 1 == k) {
      return nums[pivotIndex];
    } else if (right - pivotIndex + 1 < k) {
      return findKthLargest(nums, k - (right - pivotIndex + 1), left, pivotIndex - 1);
    } else {
      return findKthLargest(nums, k, pivotIndex + 1, right);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
