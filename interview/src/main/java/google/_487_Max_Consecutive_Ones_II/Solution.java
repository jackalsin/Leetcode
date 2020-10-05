package google._487_Max_Consecutive_Ones_II;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int zeroCount = 0, start = 0, maxOneCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroCount++;
        while (zeroCount > 1) {
          if (nums[start] == 0) {
            zeroCount--;
          }
          start++;
        }
      }
      maxOneCount = Math.max(maxOneCount, i - start + 1);
    }
    return maxOneCount;
  }
}
