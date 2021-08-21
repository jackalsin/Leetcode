package airbnb._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 8/20/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int rob = nums[0], noRob = 0;
    for (int i = 1; i < nums.length; ++i) {
      final int prevRob = rob, prevNoRob = noRob;
      rob = prevNoRob + nums[i];
      noRob = Math.max(prevNoRob, prevRob);
    }
    return Math.max(rob, noRob);
  }
}
