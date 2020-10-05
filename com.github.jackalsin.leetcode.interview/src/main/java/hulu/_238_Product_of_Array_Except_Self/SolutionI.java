package hulu._238_Product_of_Array_Except_Self;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    final int n = nums.length;
    final int[] result = new int[n];
    result[0] = 1;
    int left = nums[0];
    for (int i = 1; i < n; ++i) {
      result[i] = left;
      left *= nums[i];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; --i) {
      result[i] *= right;
      right *= nums[i];
    }
    return result;
  }
}
