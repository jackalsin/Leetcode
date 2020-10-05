package linkedin._238_Product_of_Array_Except_Self;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public int[] productExceptSelf(int[] nums) {
    assert nums.length > 1;
    final int[] result = new int[nums.length];
    Arrays.fill(result, 1);
    int left = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] *= left;
      left *= nums[i];
    }

    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= right;
      right *= nums[i];
    }

    return result;
  }
}
