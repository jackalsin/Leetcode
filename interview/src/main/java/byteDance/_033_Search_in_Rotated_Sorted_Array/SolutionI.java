package byteDance._033_Search_in_Rotated_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
public final class SolutionI implements Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] >= nums[left]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    } // end while loop
    return -1;
  }
}
