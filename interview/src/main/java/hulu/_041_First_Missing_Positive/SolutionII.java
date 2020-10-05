package hulu._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 2/28/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    for (int i = 0; i < nums.length; ++i) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
