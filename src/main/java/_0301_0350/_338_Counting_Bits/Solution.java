package _0301_0350._338_Counting_Bits;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public class Solution {

  public int[] countBits(int num) {
//    return mySolution(num);
    return betterSolution(num);
  }

  private int[] betterSolution(int num) {
    final int[] result = new int[num + 1];
    for (int i = 1; i <= num; ++i) {
      result[i] = result[i >> 1] + (i & 1);
    }
    return result;
  }

  private int[] mySolution(int num) {
    final int[] result = new int[num + 1];
    result[1] = 1;

    for (int base = 2; base <= num; base <<= 1) {
      result[base] = 1;
      for (int i = 1; i < Math.min(base, num - base + 1); ++i) {
        result[i + base] = result[base] + result[i];
      }
    }
    return result;

  }
}
