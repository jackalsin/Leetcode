package interviews.google._215_Kth_Largest_Element_in_an_Array;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class Solution {

  public int findKthLargest(int[] nums, int k) {
    return quickSelection(nums, k, 0, nums.length - 1);
  }

  private int quickSelection(int[] nums, int k, final int start, final int end) {
    int left = start, right = end;
    assert left <= right;
    if (left == right) {
      return nums[left];
    }
    int pivotIndex = left + (right - left) / 2, pivot = nums[pivotIndex];
    while (left < right) {
      while (left <= right && nums[left] < pivot) {
        left++;
      }
      while (right >= left && nums[right] > pivot) {
        right--;
      }
      if (left < right) {
        swap(nums, left++, right--);
      }
    }
    /* 此时left 和 right 应该在 pivot value 的left 和 right */
    final int n = nums.length;
    if (left == n - k) {
      return nums[left];
    } else if (left < n - k) {
      return quickSelection(nums, k, left + 1, end);
    } else {
      return quickSelection(nums, k - (n - right), start, right - 1);
    }

  }

  private void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
