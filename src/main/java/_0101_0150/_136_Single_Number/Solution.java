package _0101_0150._136_Single_Number;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else {
      int result = 0;
      for (int i : nums) {
        result ^= i;
      }
      return result;
    }
  }
}
