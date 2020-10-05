package _0001_0050._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
public final class SolutionI implements Solution {

  /**
   * Given an unsorted integer array, find the first missing positive integer.
   * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
    if (nums == null) {
      return 1;
    }
    final int n = nums.length;
    for (int i = 0; i < n; i++) {
      // 5 要在 nums[4]
      while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) return i + 1;
    }
    return n + 1;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
