package byteDance._034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    return new int[]{first(nums, target), last(nums, target)};
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
    return nums[left] == target ? left : -1;
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
    return nums[left] == target ? left : -1;
  }
}
