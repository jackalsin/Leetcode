package doordash._795_Number_of_Subarrays_with_Bounded_Maximum;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return numSubarrayBoundedMax(nums, right) - numSubarrayBoundedMax(nums, left - 1);
  }

  private static int numSubarrayBoundedMax(final int[] nums, int max) {
    int res = 0, cur = 0;
    for (int num : nums) {
      cur = num <= max ?  cur + 1: 0;
      res += cur;
    }
    return res;
  }
}
