package linkedin._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxRob = nums[0], maxNotRob = 0;
    for (int i = 1; i < nums.length; ++i) {
      final int prevMaxRob = maxRob,
          prevMaxNotRob = maxNotRob;
      maxRob = prevMaxNotRob + nums[i];
      maxNotRob = Math.max(prevMaxRob, prevMaxNotRob);
    }
    return Math.max(maxRob, maxNotRob);
  }
}
