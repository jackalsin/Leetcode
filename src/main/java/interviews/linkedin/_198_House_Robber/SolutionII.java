package interviews.linkedin._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSteal = nums[0], maxNoSteal = 0;

    for (int i = 1; i < nums.length; i++) {
      final int prevMaxSteal = maxSteal, prevMaxNoSteal = maxNoSteal;
      maxSteal = nums[i] + prevMaxNoSteal;
      maxNoSteal = Math.max(prevMaxSteal, prevMaxNoSteal);
    }

    return Math.max(maxSteal, maxNoSteal);
  }
}
