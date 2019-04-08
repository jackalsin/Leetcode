package interviews.airbnb.maxNightsCanAccommodate;

public final class SolutionII implements Solution {
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
  public int maxNightsCanAccommodate(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int[] dp = new int[nums.length + 1];
    dp[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
    }
    return dp[dp.length - 1];
  }

}
