package interviews.microsoft._162_Find_Peak_Element;

public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0; // illegal
    }

    if (nums.length == 1) {
      return 0;
    }

//    assert nums.length > 1;
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (isPeak(nums, mid)) {
        return mid;
      } else {
        if (nums[left] > nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }

    throw new IllegalStateException("No people can reach here");
  }

  private static boolean isPeak(int[] nums, int mid) {
    assert nums.length >= 2;
    if (mid == 0) {
      return nums[0] > nums[1];
    } else if (mid == nums.length - 1) {
      return nums[mid] > nums[mid - 1];
    } else {
      return nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1];
    }
  }
}
