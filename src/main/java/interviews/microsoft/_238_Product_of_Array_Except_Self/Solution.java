package interviews.microsoft._238_Product_of_Array_Except_Self;

public class Solution {

  public int[] productExceptSelf(int[] nums) {
    final int[] res = new int[nums.length];

    int num = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = num;
      num *= nums[i];
    }

    num = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= num;
      num *= nums[i];
    }

    return res;
  }

}
