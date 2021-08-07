package linkedin._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 9/19/2019
 */
public final class SolutionVII implements Solution {
  @Override
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    final int n = nums.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] > nums[right]) {
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, left, mid, target);
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, mid, right, target);
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  private static int binarySearch(final int[] nums, int left, int right, final int target) {
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] < target) left = mid + 1;
      else right = mid - 1;
    } // should not here
    return -1;
  }
}
