package _0501_0550._548_Split_Array_with_Equal_Sum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean splitArray(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    final int len = nums.length;
    final long[] sum = getSum(nums);
    for (int j = 3; j < len; ++j) {
      final Set<Long> seen = new HashSet<>();
      for (int i = 1; i < j; i++) {
        final long sum1 = sum[i], sum2 = sum[j] - sum[i + 1];
        if (sum1 == sum2) {
          seen.add(sum1);
        }
      } // end of <code>i</code>
      for (int k = j + 1; k < len - 1; k++) {
        final long sum3 = sum[k] - sum[j + 1], sum4 = sum[sum.length - 1] - sum[k + 1];
        if (sum3 == sum4 && seen.contains(sum3)) {
          return true;
        }
      }
    }
    return false;
  }

  private static long[] getSum(final int[] nums) {
    final long[] sums = new long[nums.length + 1];
    for (int i = 0; i < nums.length; ++i) {
      sums[i + 1] = sums[i] + nums[i];
    }
    return sums;
  }
}
