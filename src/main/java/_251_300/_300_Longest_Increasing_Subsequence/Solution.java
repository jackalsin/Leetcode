package _251_300._300_Longest_Increasing_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class Solution {
  /**
   *
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
    return oNSquareSolution(nums);
  }

  private static int oNSquareSolution(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    // longest[i] means the longest increasing sequence ending with longest[i]
    final int[] longest = new int[nums.length];
    longest[0] = 1;
    int max = 1;
    for (int end = 1; end < nums.length; ++end) {
      longest[end] = 1;
      for (int i = 0; i < end; ++i) {
        if (nums[end] > nums[i] && (longest[end] < longest[i] + 1)) {
          longest[end] = longest[i] + 1;
          if (longest[end] > max) {
            max = longest[end];
          }
        }
      }
    }
    return max;
  }

}
