package linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionV implements Solution {
  @Override
  public int maxProduct(int[] nums) {
    if (nums == null) return 0;
    int maxSoFar = nums[0], minSoFar = nums[0], maxEndHere = nums[0], minEndHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      final int prevMaxEndHere = maxEndHere, prevMinEndHere = minEndHere;
      maxEndHere = max(nums[i], prevMaxEndHere * nums[i], prevMinEndHere * nums[i]);
      minEndHere = min(nums[i], prevMaxEndHere * nums[i], prevMinEndHere * nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
      minSoFar = Math.min(minSoFar, minEndHere);
    }
    return maxSoFar;
  }

  private static int min(int a, final int... b) {
    for (int c : b) a = Math.min(a, c);
    return a;
  }

  private static int max(int a, final int... b) {
    for (int c : b) a = Math.max(a, c);
    return a;
  }

}
