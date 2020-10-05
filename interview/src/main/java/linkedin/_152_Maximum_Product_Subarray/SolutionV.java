package linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionV implements Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int minProdEndHere = nums[0],
        maxProdEndHere = nums[0],
        maxSoFar = nums[0];
    for (int i = 1; i < nums.length; i++) {
      final int prevMinProdEndHere = minProdEndHere,
          prevMaxProdEndHere = maxProdEndHere;
      minProdEndHere = min(prevMinProdEndHere * nums[i], prevMaxProdEndHere * nums[i], nums[i]);
      maxProdEndHere = max(prevMinProdEndHere * nums[i], prevMaxProdEndHere * nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxProdEndHere);
    }
    return maxSoFar;
  }

  private static int min(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }

  private static int max(int a, int b, int c) {
    return Math.max(Math.max(a, b), c);
  }
}
