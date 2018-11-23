package _0451_0500._485_Max_Consecutive_Ones;

/**
 * @author jacka
 * @version 1.0 on 12/1/2017.
 */
public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, cur = 0;
    for (int curVal : nums) {
      if (curVal == 1) {
        cur++;
      } else {
        max = Math.max(max, cur);
        cur = 0;
      }
    }
    return Math.max(max, cur);
  }
}
