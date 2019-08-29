package interviews.linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 8/28/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int minEndHere = nums[0], maxEndHere = nums[0], max = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      final int prevMin = minEndHere, prevMax = maxEndHere;
      minEndHere = min(prevMin * nums[i], prevMax * nums[i], nums[i]);
      maxEndHere = max(prevMin * nums[i], prevMax * nums[i], nums[i]);
      max = max(max, maxEndHere);
    }

    return max;
  }

  private static int min(final int a, final int... b) {
    int res = a;
    for (int c : b) {
      res = Math.min(c, res);
    }
    return res;
  }

  private static int max(final int a, final int... b) {
    int res = a;
    for (int c : b) {
      res = Math.max(c, res);
    }
    return res;
  }
}
