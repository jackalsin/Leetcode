package apple._238_Product_of_Array_Except_Self;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] productExceptSelf(int[] nums) {
    final int n = nums.length;
    final int[] result = new int[n];
    if (n == 0) {
      return result;
    }
    result[0] = 1;
    int left = 1;
    for (int i = 0; i < n; ++i) {
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
