package interviews.oracle._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
