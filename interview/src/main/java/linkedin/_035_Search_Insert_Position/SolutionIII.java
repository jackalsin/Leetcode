package linkedin._035_Search_Insert_Position;

public final class SolutionIII implements Solution {
  @Override
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) return 0;
    if (target < nums[0]) return 0;
    if (target > nums[nums.length - 1]) return nums.length;
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
