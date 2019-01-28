package interviews.airbnb._215_Kth_Largest_Element_in_an_Array;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public final class Solution {
  public int findKthLargest(int[] nums, int k) {
    assert 1 <= k && k <= nums.length;
    final int pivotIndex = partition(nums, 0, nums.length - 1, k);
    return nums[pivotIndex];
  }

  private int partition(final int[] nums, final int start, final int end, final int k) {
    if (start >= end) {
      return start;
    }
    final int pivotVal = nums[end];
    int storeIndex = start;
    for (int i = start; i < end; i++) {
      if (nums[i] <= pivotVal) {
        swap(nums, i, storeIndex);
        storeIndex++;
      }
    }
    swap(nums, storeIndex, end);

    final int pivotIndex = storeIndex, greaterThanLen = end - (pivotIndex + 1) + 1;
    if (greaterThanLen + 1 == k) {
      return pivotIndex;
    } else if (greaterThanLen + 1 > k) {
      return partition(nums, pivotIndex + 1, end, k);
    } else {
      return partition(nums, start, pivotIndex - 1, k - greaterThanLen - 1);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
