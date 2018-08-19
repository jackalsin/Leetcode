package _051_100._081_Search_in_Rotated_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 5/14/2017.
 */
public final class MySolution implements Solution {
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) { // nico nico
      int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
        left++;
        right--;
      } else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          return binarySearch(nums, target, left, mid);
        } else {
          left = mid + 1;
        }
      } else {
        assert nums[mid] <= nums[right];
        if (nums[mid] <= target && target <= nums[right]) {
          return binarySearch(nums, target, mid, right);
        } else {
          right = mid - 1;
        }
      }
    }
    return false;
  }

  boolean binarySearch(int[] nums, int target, int start, int end) {
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
