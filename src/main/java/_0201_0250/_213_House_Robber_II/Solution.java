package _0201_0250._213_House_Robber_II;

/**
 * @author jacka
 * @version 1.0 on 8/9/2017.
 */
public class Solution {
  public int rob(int[] nums) {
    if (nums == null) {
      throw new NullPointerException();
    } else if (nums.length == 1) {
      return nums[0];
    } else {
      return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
  }

  /**
   *
   * @param nums
   * @param start inclusive
   * @param end   inclusive
   * @return
   */
  private int rob(int[] nums, int start, int end) {
    int prevSteal = 0, prevNoSteal = 0;
    for(int i = start; i <= end; ++i) {
      int curSteal = prevNoSteal + nums[i];
      int curNoSteal = Math.max(prevSteal, prevNoSteal);
      prevSteal = curSteal;
      prevNoSteal = curNoSteal;
    }

    return Math.max(prevSteal, prevNoSteal);
  }
}
