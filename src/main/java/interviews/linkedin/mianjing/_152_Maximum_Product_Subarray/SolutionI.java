package interviews.linkedin.mianjing._152_Maximum_Product_Subarray;

public final class SolutionI implements Solution {

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSoFar = nums[0], maxEndHere = nums[0], minEndHere = nums[0];
    for (int i = 1; i < nums.length; i++) {
      final int preMaxEndHere = maxEndHere, prevMinEndHere = minEndHere;
      maxEndHere = Math.max(Math.max(preMaxEndHere * nums[i], prevMinEndHere * nums[i]), nums[i]);
      minEndHere = Math.min(Math.min(preMaxEndHere * nums[i], prevMinEndHere * nums[i]), nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
