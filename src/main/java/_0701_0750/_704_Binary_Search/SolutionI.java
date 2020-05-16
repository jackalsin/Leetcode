package _0701_0750._704_Binary_Search;

/**
 * @author jacka
 * @version 1.0 on 5/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int search(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
