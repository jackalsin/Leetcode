package interviews.google._215_Kth_Largest_Element_in_an_Array;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class Solution {
  /**
   * Time Complexity O(N)
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest(int[] nums, int k) {
    int left = 0, right = nums.length - 1;
    final int n = nums.length;
    while (true) {
      int pos = partition(nums, left, right);
      if (pos == n - k) {
        return nums[pos];
      } else if (pos < n - k) {
        left = pos + 1;
      } else {
        right = pos - 1;
      }
    }
  }

  int partition(int[] nums, final int left, final int right) {
    assert left <= right;
    int pivotVal = nums[right], storeIndex = left;
    for (int i = left; i < right; i++) {
      if (nums[i] < pivotVal) {
        swap(nums, storeIndex++, i);
      }
    }
    swap(nums, right, storeIndex);
    return storeIndex;
  }


  private void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
