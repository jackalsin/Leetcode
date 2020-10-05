package byteDance._041_First_Missing_Positive;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int firstMissingPositive(int[] nums) {
    final int n = nums.length;
    for (int i = 0; i < n; ++i) {
      // if we find 5, swapping with num[4]
      while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
      }
    }
//    System.out.println(Arrays.toString(nums));
    for (int i = 1; i <= n; ++i) {
      if (nums[i - 1] != i) {
        return i;
      }
    }
    return n + 1;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
