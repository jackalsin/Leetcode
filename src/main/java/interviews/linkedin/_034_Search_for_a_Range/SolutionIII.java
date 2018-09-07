package interviews.linkedin._034_Search_for_a_Range;

public class SolutionIII implements Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    int left = getFirstOccurrance(nums, target),
        right = getLastOccurrance(nums, target);
    return new int[]{left, right};
  }

  private static int getFirstOccurrance(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return nums[left] == target ? left : -1;
  }

  private static int getLastOccurrance(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = (right - left + 1) / 2 + left;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return nums[left] == target ? left : -1;
  }

}
