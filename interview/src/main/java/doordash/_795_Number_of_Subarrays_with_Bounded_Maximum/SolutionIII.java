package doordash._795_Number_of_Subarrays_with_Bounded_Maximum;

/**
 * @author jacka
 * @version 1.0 on 7/12/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return countLessThanOrEqualsTo(nums, right) - countLessThanOrEqualsTo(nums, left - 1);
  }

  private static int countLessThanOrEqualsTo(final int[] nums, final int max) {
    int res = 0, count = 0;
    for (int num : nums) {
      count = num <= max ? count + 1 : 0;
      res += count;
    }
    return res;
  }
}
