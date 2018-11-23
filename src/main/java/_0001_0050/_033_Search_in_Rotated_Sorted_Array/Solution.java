package _0001_0050._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 2017/2/7.
 */
public class Solution {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    return search(nums, target, 0, nums.length - 1);
  }

  private int search(int[] nums, int target, int fromIndex, int toIndex) {
    if (fromIndex > toIndex) return -1;
    int mid = (toIndex - fromIndex) / 2 + fromIndex;
    if (nums[mid] >= nums[toIndex]) { // mid is in sorted array
      if (nums[mid] >= target && target >= nums[fromIndex]) {
        return binarySearch(nums, target, fromIndex, mid);
      } else {
        return search(nums, target, mid + 1, toIndex);
      }
    } else {
      if (nums[mid] <= target && target <= nums[toIndex]) {
        return binarySearch(nums, target, mid, toIndex);
      } else {
        return search(nums, target, fromIndex, mid - 1);
      }
    }
  }

  /**
   * @param nums
   * @param target
   * @param fromIndex inclusive
   * @param toIndex   inclusive
   * @return
   */
  private int binarySearch(int[] nums, int target, int fromIndex, int toIndex) {
    while (fromIndex <= toIndex) {
      int mid = (toIndex - fromIndex) / 2 + fromIndex;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        toIndex = mid - 1;
      } else {
        fromIndex = mid + 1;
      }
    }
    return -1;
  }
}
