package linkedin._198_House_Robber;

public final class SolutionV implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int rob = nums[0], noRob = 0;
    for (int i = 1; i < nums.length; ++i) {
      final int prevRob = rob, prevNoRob = noRob;
      noRob = Math.max(prevRob, prevNoRob);
      rob = prevNoRob + nums[i];
    }
    return Math.max(rob, noRob);
  }
}
