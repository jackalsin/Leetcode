package interviews.linkedin._300_Longest_Increasing_Subsequence;

public class Solution {
  public int lengthOfLIS(int[] nums) {
    // tails[i] indicates the min last elements with length i + 1
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[] tails = new int[nums.length];
    tails[0] = nums[0];
    int len = 1;
    for (int num : nums) {

      int left = 0, right = len - 1;
      while (left < right) {
        final int mid = (right - left) / 2 + left;
        // first greater or equals to

        if (tails[mid] >= num) {
          right = mid;
        } else {
          left = mid + 1;
        }

      } // end of while

      if (tails[left] < num) { // no valid
        len++;
        left = len - 1;
      }
      tails[left] = num;
    }
    return len;
  }
}
