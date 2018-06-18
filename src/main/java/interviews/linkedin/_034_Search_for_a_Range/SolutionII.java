package interviews.linkedin._034_Search_for_a_Range;

/**
 * @author jacka
 * @version 1.0 on 10/16/2017.
 */
public final class SolutionII implements Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    return new int[]{firstOccur(nums, target, 0, nums.length - 1), lastOccur(nums, target, 0, nums.length - 1)};
  }

  private static int firstOccur(final int[] nums, final int target, int left, int right) {

    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] >= target) {
        right = mid;
      } else { // mid < target
        left = mid + 1;
      }
    }
    if (nums[left] != target) {
      return -1;
    }
    return left;
  }

  private static int lastOccur(final int[] nums, final int target, int left, int right) {
    while (left < right) {
      final int mid = (right - left + 1) / 2 + left;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (nums[left] != target) {
      return -1;
    }
    return left;
  }
}
