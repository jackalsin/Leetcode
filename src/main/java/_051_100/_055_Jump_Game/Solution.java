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

    boolean[] ableToJumpHere = new boolean[nums.length];
    ableToJumpHere[0] = true;
    for (int i = 0; i < nums.length; i++) {
      if (ableToJumpHere[i]) {
        if (i + nums[i] >= nums.length - 1) {
          return true;
        }
        Arrays.fill(ableToJumpHere, i, i + nums[i] + 1, true);
      }
    }
    return ableToJumpHere[nums.length - 1];
  }
}
