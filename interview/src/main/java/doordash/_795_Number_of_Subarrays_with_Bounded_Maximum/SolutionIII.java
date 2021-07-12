package doordash._795_Number_of_Subarrays_with_Bounded_Maximum;

/**
 * @author jacka
 * @version 1.0 on 7/12/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return numSubarrayBoundedMax(nums, right) - numSubarrayBoundedMax(nums, left - 1);
  }

  private int numSubarrayBoundedMax(int[] nums, int right) {
    int res = 0, cur = 0;
    for (int n : nums) {
      cur = n <= right ? cur + 1 : 0;
      res += cur;
    }
    return res;
  }
}
