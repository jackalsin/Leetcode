package interviews.oracle._075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionII implements Solution {
  @Override
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    final int n = nums.length;
    for (int zero = 0, one = 0, two = n - 1; one <= two; ) {
      if (nums[one] == 1) {
        one++;
      } else if (nums[one] == 0) {
        swap(nums, zero, one);
        zero++;
        one++;
      } else {
        swap(nums, one, two);
        two--;
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
