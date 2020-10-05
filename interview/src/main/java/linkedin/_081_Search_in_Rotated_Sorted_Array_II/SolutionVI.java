package linkedin._081_Search_in_Rotated_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 10/2/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public boolean search(int[] nums, int target) {
    if (nums == null) {
      return false;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return true;
      } else if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        ++left;
        --right;
      } else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
    }
    return false;
  }
}
