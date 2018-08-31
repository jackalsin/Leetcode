package interviews.linkedin.mianjing._033_Search_in_Rotated_Sorted_Array;

public class Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] < nums[right]) { // right side is sorted
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, target, left, right);
        } else {
          right = mid - 1;
        }
      } else { // left side
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
      final int mid = (right - left) / 2 + left;
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
