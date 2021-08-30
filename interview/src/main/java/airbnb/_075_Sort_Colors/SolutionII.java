package airbnb._075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 8/29/2021
 */
public final class SolutionII implements Solution {
  @Override
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) return;
    for (int first = 0, second = nums.length - 1, zero = 0;
         first <= second; ) {
      if (nums[first] == 0) {
        swap(nums, first++, zero++);
      } else if (nums[first] == 2) {
        swap(nums, first, second--);
      } else {
        first++;
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
