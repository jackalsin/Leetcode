package interviews.facebook._209_Minimum_Size_Subarray_Sum;

public class Solution {
  /**
   * Given an array of n positive integers and a positive integer s   * @param s
   *
   * @param nums
   * @return
   */
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int left = 0, right = 0, sum = 0, minLen = Integer.MAX_VALUE;
    while (right < nums.length) {
      sum += nums[right];

      while (sum >= s) {
        minLen = Math.min(minLen, right - left + 1);
        sum -= nums[left];
        left++;
      }

      right++;
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
