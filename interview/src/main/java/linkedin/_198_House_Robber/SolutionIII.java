package linkedin._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 8/5/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxRobEndHere = nums[0], maxNotRobEndHere = 0;
    for (int i = 1; i < nums.length; i++) {
      final int prevRob = maxRobEndHere,
          prevNotRob = maxNotRobEndHere;
      maxRobEndHere = prevNotRob + nums[i];
      maxNotRobEndHere = Math.max(maxNotRobEndHere, prevRob);
    }
    return Math.max(maxNotRobEndHere, maxRobEndHere);
  }
}
