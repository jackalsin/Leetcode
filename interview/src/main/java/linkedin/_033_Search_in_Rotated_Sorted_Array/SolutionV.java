package linkedin._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 6/26/2019
 */
public final class SolutionV implements Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    return search(nums, target, 0, nums.length - 1);
  }

  private static int search(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, target, left, mid);
        } else {
          left = mid + 1;
        }
      } else { // right side is sorted
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
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        return mid;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

}
