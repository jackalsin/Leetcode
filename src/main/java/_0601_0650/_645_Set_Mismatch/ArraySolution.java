package _0601_0650._645_Set_Mismatch;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/8/2020
 */
public final class ArraySolution implements Solution {
  @Override
  public int[] findErrorNums(int[] nums) {
    final int n = nums.length;
    final int[] counts = new int[n],
        result = new int[2];
    Arrays.fill(counts, 1);
    for (int num : nums) {
      counts[num - 1]--;
      if (counts[num - 1] == -1) {
        result[0] = num;
      }
    }
    for (int i = 0; i < nums.length; ++i) {
      if (counts[i] == 1) { // never show up
        result[1] = i + 1;
      }
    }
    return result;
  }
}
