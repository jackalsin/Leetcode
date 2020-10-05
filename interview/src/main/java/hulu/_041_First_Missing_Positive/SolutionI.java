package hulu._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int firstMissingPositive(int[] nums) {
    final int n = nums.length;
    for (int i = 0; i < n; ++i) {
      // nums[4] = 5
      while (nums[i] >= 1 && nums[i] <= n && nums[i] - 1 != i) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 1; i <= n; ++i) {
      if (nums[i - 1] != i) return i;
    }
    return n + 1;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int n = nums[j];
    nums[j] = nums[i];
    nums[i] = n;
  }
}
