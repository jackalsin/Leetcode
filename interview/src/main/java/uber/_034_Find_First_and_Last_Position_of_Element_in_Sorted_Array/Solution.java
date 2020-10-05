package uber._034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {
  public int[] searchRange(int[] nums, int target) {

    return new int[]{first(nums, target), last(nums, target)};
  }

  private static int first(final int[] nums, final int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left < right) { // first occurrence
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

  private static int last(final int[] nums, final int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left + 1) / 2;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    return nums[left] == target ? left : -1;
  }

}
