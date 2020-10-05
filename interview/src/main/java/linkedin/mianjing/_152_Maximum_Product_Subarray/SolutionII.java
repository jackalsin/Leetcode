package linkedin.mianjing._152_Maximum_Product_Subarray;

public final class SolutionII implements Solution {

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxEndHerePos = Math.max(nums[0], 0), maxSoFarPos = nums[0],
        minEndHereNeg = Math.min(nums[0], 0);
    for (int i = 1; i < nums.length; ++i) {
      final int prevMaxEndHerePos = maxEndHerePos,
          prevMinEndHereNeg = minEndHereNeg;
      if (nums[i] == 0) {
        maxEndHerePos = 0;
        minEndHereNeg = 0;
      } else if (nums[i] < 0) {
        maxEndHerePos = prevMinEndHereNeg * nums[i];
        minEndHereNeg = Math.min(prevMaxEndHerePos * nums[i], nums[i]);
      } else {
        maxEndHerePos = Math.max(nums[i], prevMaxEndHerePos * nums[i]);
        minEndHereNeg = prevMinEndHereNeg * nums[i];
      }
      maxSoFarPos = Math.max(maxSoFarPos, maxEndHerePos);
    }
    return maxSoFarPos;
  }
}
