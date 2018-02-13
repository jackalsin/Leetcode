package interviews.uber._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  private int search(final int[] nums, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    int midIndex = left + (right - left) / 2;
    if (nums[midIndex] <= nums[right]) { // mid ... right is order
      if (target <= nums[right] && target >= nums[midIndex]) {
        return binarySearch(nums, target, midIndex, right);
      } else {
        return search(nums, target, left, midIndex - 1);
      }
    } else {
      if (nums[left] <= target && target <= nums[midIndex]) {
        return binarySearch(nums, target, left, midIndex);
      } else {
        return search(nums, target, midIndex + 1, right);
      }
    }
  }

  private int binarySearch(final int[] nums, final int target, int left, int right) {
    while (left <= right) {
      int mid = (right - left) / 2 + left;
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
