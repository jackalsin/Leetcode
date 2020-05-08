package interviews.byteDance._215_Kth_Largest_Element_in_an_Array;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findKthLargest(int[] nums, int k) {
    return findKthLargest(nums, k, 0, nums.length - 1);
  }

  private static int findKthLargest(final int[] nums, final int k, final int left, final int right) {
    assert left <= right;
    if (left == right) {
      return nums[left];
    }
    final int pivotVal = nums[right];
    int p = left;
    for (int i = left; i < right; ++i) {
      if (nums[i] <= pivotVal) {
        swap(nums, i, p);
        p++;
      }
    }
    swap(nums, p, right);
    // [left, p] value will smaller than or equals to pVal
    if (k == right - p + 1) {
      return nums[p];
    } else if (k > right - p + 1) {
      return findKthLargest(nums, k - (right - p + 1), left, p - 1);
    } else {
      return findKthLargest(nums, k, p + 1, right);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
