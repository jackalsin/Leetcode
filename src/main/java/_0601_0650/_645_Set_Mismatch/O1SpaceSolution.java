package _0601_0650._645_Set_Mismatch;

/**
 * @author jacka
 * @version 1.0 on 3/8/2020
 */
public final class O1SpaceSolution implements Solution {
  /**
   * @return {duplicate, missing}
   */
  @Override
  public int[] findErrorNums(int[] nums) {
    // 假设我们missing的int为a，duplicate的为b
    // xor 最终会变成 a^b
    int xor = 0;
    for (int i = 0; i < nums.length; ++i) {
      xor ^= (nums[i] ^ (i + 1));
    }

    xor &= (-xor); // 变成least significant
    // 我们把所有的数字分为两类：
    // 1）与 xor & 之后直接为0
    // 2） 与xor & 之后非零
    // 最终num1 and num2, one will become the duplicate and the other will be the missing one.
    int num1 = 0, num2 = 0;
    for (int i = 0; i < nums.length; ++i) {
      if ((nums[i] & xor) == 0) {
        num1 ^= nums[i];
      } else {
        num2 ^= nums[i];
      }
      if (((i + 1) & xor) == 0) {
        num1 ^= (i + 1);
      } else {
        num2 ^= (i + 1);
      }
//      System.out.println("num1 = " + num1 + ", num2 = " + num2 + ", i = " + i);
    }

    // determine who is missing
    for (int num : nums) {
      if (num == num1) {
        return new int[]{num1, num2};
      }
    }
    return new int[]{num2, num1};
  }
}
