package linkedin._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int preSteal = nums[0], preNoSteal = 0;
    for (int i = 1; i < nums.length; ++i) {
      int curSteal = preNoSteal + nums[i];
      int curNoSteal = Math.max(preNoSteal, preSteal);
      preNoSteal = curNoSteal;
      preSteal = curSteal;
    }
    return Math.max(preNoSteal, preSteal);
  }
}
