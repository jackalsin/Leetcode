package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 9/19/2019
 */
public final class SolutionVII implements Solution {
  @Override
  public int search(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, target, left, right);
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, target, mid, right);
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  private static int binarySearch(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
