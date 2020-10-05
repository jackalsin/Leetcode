package hulu._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 2/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int robbed = nums[0], notRobbed = 0;
    for (int i = 1; i < nums.length; ++i) {
      final int prevRobbed = robbed,
          prevNot = notRobbed;
      robbed = prevNot + nums[i];
      notRobbed = Math.max(prevRobbed, prevNot);
    }
    return Math.max(robbed, notRobbed);
  }
}
