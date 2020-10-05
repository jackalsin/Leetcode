package linkedin._153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionII implements Solution {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] <= nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return nums[left];
  }
}
