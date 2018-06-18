package interviews.linkedin._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionII implements Solution {
  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  private static int search(final int[] nums, final int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    if (left == right) {
      return target == nums[left] ? left : -1;
    }
    final int mid = (right - left) / 2 + left;
    if (nums[mid] > nums[right]) { // 应该是nums[left] 还是right
      // left side sorted
      if (nums[left] <= target && target <= nums[mid]) {
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

  private static int binarySearch(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return mid;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

}
