package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;

public final class SolutionV implements Solution {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) { // TODO: equals
      final int mid = (right - left) / 2 + left;
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

    return -1;
  }

  private static int binarySearch(final int[] nums, final int target, int left, int right) {
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
