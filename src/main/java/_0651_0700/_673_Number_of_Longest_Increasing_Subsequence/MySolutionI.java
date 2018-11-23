package _0651_0700._673_Number_of_Longest_Increasing_Subsequence;

import java.util.Arrays;

public final class MySolutionI implements Solution {
  // This solution is not feasible due to the count calculation
  public int findNumberOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[] tail = new int[nums.length], count = new int[nums.length];
    int size = 1;
    tail[0] = nums[0];
    count[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      int target = nums[i];
      int left = 0, right = size - 1;

      // find the first occurrence greater than or equals to
      while (left < right) {
        final int mid = (right - left) / 2 + left;
        if (nums[mid] >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      if (nums[left] < target) { // all of them are smaller than
        left = size;
        size++;
      }

      if (left != 0) {
        count[left] += count[left - 1];
      } else if (tail[left] == target) {
        count[left]++;
      }
      tail[left] = target;
      System.out.println(Arrays.toString(tail));
      System.out.println(Arrays.toString(count));
    }
    return count[size - 1];
  }
}
