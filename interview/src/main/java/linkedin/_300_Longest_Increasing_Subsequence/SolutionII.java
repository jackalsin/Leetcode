package linkedin._300_Longest_Increasing_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 8/10/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int end = 0;
    for (int i = 1; i < nums.length; ++i) {
      final int k = firstGreaterThanOrEquals(dp, nums[i], end);
      dp[k] = nums[i];
      if (k > end) {
        end = k;
      }
    }
    return end + 1;
  }

  /**
   * @param nums   input
   * @param target value to find
   * @param end    inclusive end
   * @return the index of first smaller than target value
   */
  private static int firstGreaterThanOrEquals(final int[] nums, final int target, final int end) {
    int left = 0, right = end;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (nums[left] >= target) {
      return left;
    }
    return end + 1;
  }
}
