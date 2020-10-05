package google._481_Magical_String;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class Solution {
  public int magicalString(int n) {
    if (n == 0) {
      return 0;
    } else if (n <= 3) {
      return 1;
    }
    final int[] nums = new int[n];
    nums[0] = 1;
    nums[1] = 2;
    nums[2] = 2;
    int num = 1, countIndex = 2, valPtr = 3, oneCounts = 1;
    while (valPtr < n) {
      int newValPtr = Math.min(n, valPtr + nums[countIndex]);
      Arrays.fill(nums, valPtr, newValPtr, num);
      if (num == 1) {
        oneCounts += Math.min(nums[countIndex], n - valPtr);
        num = 2;
      } else {
        num = 1;
      }
      valPtr = newValPtr;
      countIndex++;
    }
//    System.out.println(Arrays.toString(nums));
    return oneCounts;
  }
}
