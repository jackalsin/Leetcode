package _051_100._081_Search_in_Rotated_Sorted_Array_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/14/2017.
 */
public class Solution {
  public boolean search(int[] nums, int target) {
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return true;
      } else if (nums[left] <= nums[mid] && target <= nums[mid]) {
        return binarySearch(nums, left, mid, target);
      } else if (nums[left] <= nums[mid] && target > nums[mid]) {
        left = mid + 1;
      } else if (nums[left] > nums[mid] && target >= nums[mid]) {
        return binarySearch(nums, mid, right, target);
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  boolean binarySearch(int[] nums, int start, int end, int target) {
    while (start <= end) {
      int mid = (end - start) / 2 + start;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }
}
