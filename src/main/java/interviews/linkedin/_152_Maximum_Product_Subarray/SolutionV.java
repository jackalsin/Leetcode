package interviews.linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionV implements Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int maxSoFar = nums[0], maxEndHere = nums[0], minEndHere = nums[0];
    for (int i = 1; i < nums.length; i++) {
      final int prevMaxEndHere = maxEndHere, prevMinEndHere = minEndHere;
      maxEndHere = Math.max(prevMaxEndHere * nums[i], prevMinEndHere * nums[i]);
      maxEndHere = Math.max(maxEndHere, nums[i]);
      minEndHere = Math.min(prevMaxEndHere * nums[i], prevMinEndHere * nums[i]);
      minEndHere = Math.min(minEndHere, nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
