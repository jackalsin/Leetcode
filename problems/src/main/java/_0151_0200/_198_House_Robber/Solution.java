package _0151_0200._198_House_Robber;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/4/2017.
 */
public class Solution {
  public int rob(int[] nums) {
//    return robEvil(nums);
    return robNormal(nums);
  }

  private static int robNormal(int[] nums) {
    int prevSteal = 0, prevNoSteal = 0;
    for (int curVal : nums) {
      int curSteal = prevNoSteal + curVal;
      int curNoSteal = Math.max(prevNoSteal, prevSteal);

      prevNoSteal = curNoSteal;
      prevSteal = curSteal;
    }
    return Math.max(prevNoSteal, prevSteal);
  }

  private static int robEvil(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else {
      int prePreMax = nums[0];
      int preMax = Math.max(nums[0], nums[1]);

      for (int i = 2; i < nums.length; i++) {
        int stealMax = Math.max(prePreMax + nums[i], preMax - nums[i - 1] + nums[i]);
        int curMax = Math.max(stealMax, preMax); // compare to the situation not steal
        prePreMax = preMax;
        preMax = curMax;
      }
      return preMax;
    }
  }
}
