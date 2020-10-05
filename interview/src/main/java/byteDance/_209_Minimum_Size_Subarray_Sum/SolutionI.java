package byteDance._209_Minimum_Size_Subarray_Sum;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null) {
      return 0;
    }
    int curSum = 0, minLen = Integer.MAX_VALUE;
    for (int left = 0, right = 0; right < nums.length; right++) {
      curSum += nums[right];
      while (curSum >= s && left <= right) {
        final int curLen = right - left + 1;
        minLen = Math.min(minLen, curLen);
        curSum -= nums[left];
        left++;
      }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
