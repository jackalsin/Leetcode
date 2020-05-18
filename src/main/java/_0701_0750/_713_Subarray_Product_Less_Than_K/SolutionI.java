package _0701_0750._713_Subarray_Product_Less_Than_K;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int left = 0, res = 0, prod = 1;
    for (int right = 0; right < nums.length; ++right) {
      prod *= nums[right];
      while (left <= right && prod >= k) {
        prod /= nums[left];
        left++;
      }
      res += Math.max(0, right - left + 1);
    }
    return res;
  }
}
