package doordash._795_Number_of_Subarrays_with_Bounded_Maximum;

/**
 * @author jacka
 * @version 1.0 on 7/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return countSumLessThanOrEqualsTo(nums, right) - countSumLessThanOrEqualsTo(nums, left - 1);
  }

  private static int countSumLessThanOrEqualsTo(final int[] nums, final int target) {
    int cur = 0, res = 0;
    for (int n : nums) {
      cur = n <= target ? cur + 1 : 0;
      res += cur;
    }
    return res;
  }
}
