package linkedin._238_Product_of_Array_Except_Self;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public int[] productExceptSelf(int[] nums) {
    final int[] result = new int[nums.length];
    int start = 1;
    for (int i = 0; i < nums.length; ++i) {
      result[i] = start;
      start *= nums[i];
    }
    int right = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; --i) {
      result[i] *= right;
      right *= nums[i];
    }

    return result;
  }
}
