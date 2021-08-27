package airbnb._280_Wiggle_Sort;

/**
 * @author jacka
 * @version 1.0 on 8/26/2021
 */
public final class SolutionII implements Solution {
  @Override
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length == 0) return;
    for (int i = 1; i < nums.length; ++i) {
      if ((i & 1) == 1) {
        if (nums[i - 1] > nums[i]) swap(nums, i);
      } else {
        if (nums[i - 1] < nums[i]) swap(nums, i);
      }
    }
  }

  private static void swap(final int[] nums, final int i) {
    assert i > 0;
    final int tmp = nums[i];
    nums[i] = nums[i - 1];
    nums[i - 1] = tmp;
  }
}
