package hulu._238_Product_of_Array_Except_Self;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/7/2020
 */
public final class SolutionIII implements Solution {
  @Override
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    final int n = nums.length;
    final int[] res = new int[n];
    Arrays.fill(res, 1);
    int left = 1;
    for (int i = 0; i < n; ++i) {
      res[i] *= left;
      left *= nums[i];
    }

    int right = 1;
    for (int i = n - 1; i >= 0; --i) {
      res[i] *= right;
      right *= nums[i];
    }
    return res;
  }
}
