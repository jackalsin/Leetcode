package _201_250._238_Product_of_Array_Except_Self;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/19/2017.
 */
public class Solution {
  public int[] productExceptSelf(int[] nums) {
    final int[] output = new int[nums.length];
    output[0] = 1;
    for (int i = 1; i < nums.length; ++i) {
      output[i] = output[i - 1] * nums[i - 1];
    }
    int right = 1;
    for (int i = nums.length - 1; i >= 0; --i) {
      output[i] *= right;
      right *= nums[i];
    }
    return output;
  }
}
