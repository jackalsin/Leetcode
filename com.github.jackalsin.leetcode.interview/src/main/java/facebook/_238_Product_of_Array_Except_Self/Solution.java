package facebook._238_Product_of_Array_Except_Self;

public class Solution {
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    final int[] res = new int[nums.length];
    int prod = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = prod;
      prod *= nums[i];
    }
    prod = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= prod;
      prod *= nums[i];
    }
    return res;
  }
}
