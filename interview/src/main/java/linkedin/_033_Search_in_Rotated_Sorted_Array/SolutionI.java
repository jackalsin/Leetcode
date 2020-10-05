package linkedin._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class SolutionI implements Solution {
  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1); // not found
  }

  private int search(int[] nums, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    final int mid = (right - left) / 2 + left;
    if (target == nums[mid]) {
      return mid;
    }
    if (nums[mid] > nums[right]) { // mid is in sorted array
      if (nums[mid] >= target && target >= nums[left]) {
        return binarySearch(nums, target, left, mid);
      } else {
        return search(nums, target, mid + 1, right);
      }
    } else {
      if (nums[mid] <= target && target <= nums[right]) {
        return binarySearch(nums, target, mid, right);
      } else {
        return search(nums, target, left, mid - 1);
      }
    }
  }

  private int binarySearch(final int[] nums, final int target, int left, int right) {
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
