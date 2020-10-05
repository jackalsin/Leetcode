package linkedin._154_Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 8/7/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == nums[right]) {
        right--;
      } else if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        assert nums[mid] > nums[right];
        left = mid + 1;
      }
    }
    return nums[left];
  }
}
