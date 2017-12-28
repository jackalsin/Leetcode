package example.binarySearch;

import java.util.Arrays;

public final class BasicSolution {

  private BasicSolution() {
  }

  public static int equalTo(final int[] nums, final int target) {
    if (nums == null) {
      throw new NullPointerException();
    }
    if (nums.length == 0) {
      throw new IllegalArgumentException("The length of nums cannot be zero.");
    }
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    throw new IllegalStateException("Cannot find the target value = " + target + " in array = " + Arrays.toString(nums));
  }
}
