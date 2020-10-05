package microsoft._033_Search_in_Rotated_Sorted_Array;

public class Solution {

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  private static int search(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] < nums[right]) {
        // [mid, right] sorted
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, target, mid, right);
        } else {
          right = mid - 1;
        }
      } else {
//        assert nums[mid ] > nums[right];
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, target, left, mid);
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }

  private static int binarySearch(int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
