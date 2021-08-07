package linkedin._034_Search_for_a_Range;

/**
 * @author jacka
 * @version 1.0 on 9/19/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1, -1};
    return new int[]{first(nums, target), last(nums, target)};
  }

  private static int first(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (nums[left] == target) return left;
    return -1;
  }

  private static int last(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (nums[left] == target) return left;
    return -1;
  }
}
