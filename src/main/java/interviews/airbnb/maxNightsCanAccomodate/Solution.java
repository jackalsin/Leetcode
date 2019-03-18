package interviews.airbnb.maxNightsCanAccomodate;

public final class Solution {
  /**
   * // [5, 1, 1, 5] => 10
   * The above array would represent an example booking period as follows -
   * // Dec 1 – 5
   * // Dec 5 – 6
   * // Dec 6 – 7
   * // Dec 7 - 12
   * <p>
   * The constrain you have is that you must reserve 1 night between 2 books
   *
   * @param nums
   * @return
   */
  public int maxNightsCanAccomodate(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }
    final int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[1], nums[0]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }
}
