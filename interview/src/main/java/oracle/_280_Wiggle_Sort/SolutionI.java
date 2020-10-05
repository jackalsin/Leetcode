package oracle._280_Wiggle_Sort;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
public final class SolutionI implements Solution {
  @Override
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    for (int i = 1; i < nums.length; ++i) {
      if (i % 2 == 1) {
        if (nums[i] < nums[i - 1]) {
          swap(nums, i, i - 1);
        }
      } else {
        if (nums[i] > nums[i - 1]) {
          swap(nums, i, i - 1);
        }
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
