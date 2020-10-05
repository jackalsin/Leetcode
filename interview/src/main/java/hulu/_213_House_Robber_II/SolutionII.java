package hulu._213_House_Robber_II;

/**
 * @author jacka
 * @version 1.0 on 2/24/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    final int n = nums.length;
    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
  }

  private static int rob(final int[] nums, final int start, final int end) {
    int rob = nums[start], noRob = 0;
    for (int i = start + 1; i <= end; ++i) {
      final int prevRob = rob, prevNoRob = noRob;
      rob = prevNoRob + nums[i];
      noRob = Math.max(prevRob, prevNoRob);
    }
    return Math.max(rob, noRob);
  }
}
