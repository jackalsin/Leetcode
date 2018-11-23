package _0551_0600._581_Shortest_Unsorted_Continuous_Subarray;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
 */
public class Solution {
  public int findUnsortedSubarray(int[] nums) {
    final int n = nums.length;
    int start = -1, end = -2, max = nums[0], min = nums[n - 1];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[n - 1 - i]);
      if (nums[i] < max) {
        end = i;
      }
      if (nums[n - 1 - i] > min) {
        start = n - 1 - i;
      }
    }
    return end - start + 1;
  }
}
