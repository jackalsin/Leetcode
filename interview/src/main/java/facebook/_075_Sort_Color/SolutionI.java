package facebook._075_Sort_Color;

/**
 * @author jacka
 * @version 1.0 on 4/22/2021
 */
public final class SolutionI implements Solution {
  @Override
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) return;
    for (int zero = 0, one = 0, two = nums.length - 1; one <= two; ++one) {
      while (one < two && nums[one] == 2) {
        swap(nums, one, two);
        two--;
      }
      while (zero < one && nums[one] == 0) {
        swap(nums, one, zero++);
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
