package linkedin._081_Search_in_Rotated_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        left++;
        right--;
      } else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        assert nums[mid] <= nums[right];
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
    }
    return false;
  }
}
