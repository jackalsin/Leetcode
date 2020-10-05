package linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionII implements Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    long maxEndHere = nums[0], minEndHere = nums[0], maxSofar = nums[0];
    for (int i = 1; i < nums.length; i++) {
      long prevMaxEndHere = maxEndHere, prevMinEndHere = minEndHere;
      maxEndHere = Math.max(Math.max(prevMaxEndHere * nums[i], prevMinEndHere * nums[i]), nums[i]);
      minEndHere = Math.min(Math.min(prevMinEndHere * nums[i], prevMaxEndHere * nums[i]), nums[i]);
      maxSofar = Math.max(maxSofar, maxEndHere);
    }
    return (int) maxSofar;
  }
}
