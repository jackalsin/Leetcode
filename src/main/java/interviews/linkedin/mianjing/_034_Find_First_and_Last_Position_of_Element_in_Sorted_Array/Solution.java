package interviews.linkedin.mianjing._034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {

  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    return new int[]{first(nums, target, 0, nums.length - 1),
        last(nums, target, 0, nums.length - 1)};
  }

  private static int first(final int[] nums, final int target, int left, int right) {
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }

  private static int last(final int[] nums, final int target, int left, int right) {
    while (left < right) {
      final int mid = (right - left + 1) / 2 + left;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }
}
