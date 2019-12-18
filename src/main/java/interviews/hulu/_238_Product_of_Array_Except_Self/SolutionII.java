package interviews.hulu._238_Product_of_Array_Except_Self;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int[] productExceptSelf(int[] nums) {
    final int n = nums.length;
    final int[] result = new int[n];
    int left = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = left;
      left *= nums[i];
    }
    int right = 1;
    for (int i = nums.length - 1; i >= 0; --i) {
      result[i] *= right;
      right *= nums[i];
    }
    return result;
  }
}
