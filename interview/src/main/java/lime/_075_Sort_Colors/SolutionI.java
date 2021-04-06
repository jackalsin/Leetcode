package lime._075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 4/6/2021
 */
public final class SolutionI implements Solution {

  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    final int n = nums.length;
    for (int zero = 0, i = 0, second = n - 1; i <= second; ++i) {
      while (nums[i] == 2 && i < second) swap(nums, i, second--);
      while (nums[i] == 0 && zero < i) swap(nums, i, zero++);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
