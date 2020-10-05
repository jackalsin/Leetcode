package uber._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  private static int search(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] < nums[right]) {
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, target, mid, right);
        } else {
          right = mid - 1;
        }
      } else {
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, target, left, mid);
        } else {
          left = mid + 1;
        }
      }
    }
    return -1; // not found
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
