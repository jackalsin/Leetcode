package _001_100._045_Jump_Game_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/23/2017.
 */
public class Solution {
  public int jump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] steps = new int[nums.length];
    Arrays.fill(steps, Integer.MAX_VALUE);
    steps[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int jumpLen = 1; jumpLen <= nums[i]; jumpLen++) {
        if (i + jumpLen < nums.length) {
          steps[i + jumpLen] = Math.min(steps[i + jumpLen], steps[i] + 1);
        }
      }
    }
    System.out.println(Arrays.toString(steps));
    return steps[nums.length - 1];
  }
}
