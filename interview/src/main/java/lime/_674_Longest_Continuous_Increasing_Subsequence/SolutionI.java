package lime._674_Longest_Continuous_Increasing_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 4/6/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int len = nums.length;
    int maxLen = 1;
    for (int i = 1, curLen = 1; i < len; ++i) {
      if (nums[i] > nums[i - 1]) {
        curLen++;
        maxLen = Math.max(maxLen, curLen);
      } else {
        curLen = 1;
      }
    }
    return maxLen;
  }
}
