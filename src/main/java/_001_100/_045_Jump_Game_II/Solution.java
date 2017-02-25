package _001_100._045_Jump_Game_II;

/**
 * @author jacka
 * @version 1.0 on 2/24/2017.
 */
public class Solution {
  public int jump(int[] nums) {
    if (nums == null|| nums.length <= 1) {
      return 0;
    }
    int curIndex = 0, currentMax = 0, nextMax = nums[0], step = 0;

    while (curIndex < nums.length) {
      step++;
      while (curIndex <= currentMax) {
        nextMax = Math.max(nextMax, curIndex + nums[curIndex]);
        if (nextMax >= nums.length - 1) return step;
        curIndex++;
      }
      currentMax = nextMax;
    }
    return step;
  }
}
