package linkedin._075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionI implements Solution {
  @Override
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) return;
    final int n = nums.length;
    for (int zero = 0, one = 0, two = n - 1;
         one <= two; ++one) {
      while (one < two && nums[one] == 2) {
        swap(nums, one, two);
        two--;
      }
      while (zero < one && nums[one] == 0) {
        swap(nums, zero++, one);
      }
    }
  } // end of sort color

  private static void swap(final int[] nums, final int i, final int j) {
    final int cmp = nums[i];
    nums[i] = nums[j];
    nums[j] = cmp;
  }
}
