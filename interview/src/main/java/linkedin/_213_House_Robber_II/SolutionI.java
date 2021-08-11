package linkedin._213_House_Robber_II;

/**
 * @author jacka
 * @version 1.0 on 8/11/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    final int n = nums.length;
    if (n == 1) return nums[0];
    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
  }

  private static int rob(final int[] nums, final int start, final int end) {
    int rob = nums[start], noRob = 0;
    for (int i = start + 1; i <= end; ++i) {
      final int prevNoRob = noRob, prevRob = rob;
      rob = prevNoRob + nums[i];
      noRob = Math.max(prevRob, prevNoRob);
    }
    return Math.max(rob, noRob);
  }
}
