package interviews.linkedin._081_Search_in_Rotated_Sorted_Array_II;

public final class SolutionIII implements Solution {
  @Override
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
        left++;
        right--;
      } else if (nums[mid] <= nums[right]) {
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, target, mid, right);
        } else {
          right = mid - 1;
        }
      } else {
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, target, left, mid);
        } else {
          left = mid + 1;
        }
      }
    }
    return false;
  }

  private static boolean binarySearch(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
