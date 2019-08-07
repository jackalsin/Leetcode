package interviews.linkedin._238_Product_of_Array_Except_Self;

/**
 * @author jacka
 * @version 1.0 on 8/6/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    final int[] result = new int[nums.length];
    int left = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = left;
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
