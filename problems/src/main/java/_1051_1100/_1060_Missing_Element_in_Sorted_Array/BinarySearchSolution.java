package _1051_1100._1060_Missing_Element_in_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 11/10/2020
 */
public final class BinarySearchSolution implements Solution {
  @Override
  public int missingElement(int[] nums, int k) {
    final int n = nums.length;
    int left = 0, right = n - 1;
    final int missing = nums[n - 1] - nums[0] - (right - left); // 两个都-1
    if (missing < k) {
      return nums[n - 1] + k - missing;
    }
    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (k > nums[mid] - nums[0] - mid) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return nums[left] + k - (nums[left] - nums[0] - left);
  }
}
