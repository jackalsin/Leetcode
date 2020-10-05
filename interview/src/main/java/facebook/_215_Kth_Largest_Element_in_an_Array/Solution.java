package facebook._215_Kth_Largest_Element_in_an_Array;

public class Solution {

  public int findKthLargest(int[] nums, int k) {
    return findKthLargest(nums, k, 0, nums.length - 1);
  }

  private int findKthLargest(final int[] nums, final int k, final int left, final int right) {
    assert left <= right;
    if (left == right) {
      return nums[left];
    }
    final int pivotIndex = partition(nums, left, right);
    if (right - pivotIndex + 1 == k) {
      return nums[pivotIndex];
    } else if (right - pivotIndex + 1 < k) {
      return findKthLargest(nums, k - (right - pivotIndex + 1), left, pivotIndex - 1);
    } else {
      return findKthLargest(nums, k, pivotIndex + 1, right);
    }
  }

  /**
   * Left part will be less than or equals to pivot value, right will be greater than.
   *
   * @param nums
   * @param left
   * @param right
   * @return
   */
  int partition(int[] nums, final int left, final int right) {
    // choose the right one as pivot
    // if not, choose any one, and swap to the right;

    int pivot = nums[right];
    int storeIndex = left;
    for (int i = left; i < right; i++) {
      if (nums[i] <= pivot) {
        swap(nums, i, storeIndex);
        storeIndex++;
      }
    }
    swap(nums, storeIndex, right);
    return storeIndex;
  }

  private static void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
