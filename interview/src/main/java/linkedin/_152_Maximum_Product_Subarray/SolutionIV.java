package linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionIV implements Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSoFar = nums[0], minEndHere = nums[0], maxEndHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      final int prevMinEndHere = minEndHere, prevMaxEndHere = maxEndHere;
      minEndHere = Math.min(Math.min(prevMinEndHere * nums[i], nums[i]), prevMaxEndHere * nums[i]);
      maxEndHere = Math.max(Math.max(prevMaxEndHere * nums[i], nums[i]), prevMinEndHere * nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }

}
