package _051_100._055_Jump_Game;

import java.util.Arrays;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
public class Solution {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    int maxReach = 0;
    for (int i = 0; i < nums.length; i++) {
      if (maxReach < i) return false;
      maxReach = Math.max(maxReach, i + nums[i]);
      if (maxReach >= nums.length - 1) return true;
    }
    return true;
  }
}
