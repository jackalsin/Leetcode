package interviews.microsoft.noodleEssence._081_Search_in_Rotated_Sorted_Array_II;

public class Solution {
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      } else if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        --right;
        ++left;
      } else if (nums[mid] <= nums[right]) { // right side is sorted
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        assert (nums[left] <= nums[mid]);
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return false;
  }

}
