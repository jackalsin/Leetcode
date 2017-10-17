package interviews.linkedin._034_Search_for_a_Range;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    final int[] result = {-1, -1};
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        result[0] = findLeft(nums, target, left, mid);
        result[1] = findRight(nums, target, mid, right);
        return result;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  private int findLeft(int[] nums, int target, int left, int right) {
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (target == nums[mid]) {
        if (mid >= 1 && nums[mid] == nums[mid - 1]) {
          right = mid - 1;
        } else {
          return mid;
        }
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    throw new IllegalStateException("You shouldn't be here.");
  }

  private int findRight(int[] nums, int target, int left, int right) {

    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (target == nums[mid]) {
        if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
          left = mid + 1;
        } else {
          return mid;
        }
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    throw new IllegalStateException("You shouldn't be here.");
  }
}
