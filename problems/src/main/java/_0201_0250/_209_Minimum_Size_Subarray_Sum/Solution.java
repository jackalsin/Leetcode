package _0201_0250._209_Minimum_Size_Subarray_Sum;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class Solution {
  /**
   * Given an array of n positive integers and a positive integer s, find the minimal length of a
   * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
   * @param s
   * @param nums
   * @return
   */
  public int minSubArrayLen(int s, int[] nums) {
    int start = 0, end = 0, min = Integer.MAX_VALUE, sum = 0;
    while (end < nums.length) {
      sum += nums[end];
      end++;
      while (sum >= s) {
        min = Math.min(min, end - start);
        sum -= nums[start++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
