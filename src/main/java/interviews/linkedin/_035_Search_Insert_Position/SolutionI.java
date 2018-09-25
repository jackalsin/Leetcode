package interviews.linkedin._035_Search_Insert_Position;

public final class SolutionI implements Solution {
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0, right = nums.length - 1;
    // find the first greater than

    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (nums[left] >= target) {
      return left;
    }
    return nums.length;
  }
}
