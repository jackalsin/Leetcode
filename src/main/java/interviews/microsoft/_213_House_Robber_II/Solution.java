package interviews.microsoft._213_House_Robber_II;

public class Solution {
  public int rob(int[] nums) { // TODO：write a blog
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  /**
   * @param nums
   * @param start start, inclusive
   * @param end   end, inclusive
   * @return
   */
  private int rob(int[] nums, int start, int end) {
    int steal = 0, noSteal = 0;
    for (int i = start; i <= end; i++) {
      final int prevSteal = steal, prevNoSteal = noSteal;
      steal = prevNoSteal + nums[i];
      noSteal = Math.max(prevSteal, prevNoSteal);
    }
    return Math.max(steal, noSteal);
  }
}
