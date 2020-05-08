package interviews.byteDance._152_Maximum_Product_Subarray;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProduct(int[] nums) {
    int maxEndHere = nums[0], minEndHere = nums[0], max = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      final int prevMaxEndHere = maxEndHere, prevMinEndHere = minEndHere;
      maxEndHere = max(prevMaxEndHere * nums[i], nums[i], prevMinEndHere * nums[i]);
      minEndHere = min(prevMinEndHere * nums[i], nums[i], prevMaxEndHere * nums[i]);
      max = Math.max(max, maxEndHere);
    }
    return max;
  }

  private static int min(int a, final int... b) {
    for (int c : b) {
      a = Math.min(a, c);
    }
    return a;
  }

  private static int max(int a, final int... b) {
    for (int c : b) {
      a = Math.max(a, c);
    }
    return a;
  }
}
