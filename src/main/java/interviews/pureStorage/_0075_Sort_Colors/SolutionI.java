package interviews.pureStorage._0075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class SolutionI implements Solution {
  @Override
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int zero = 0, one = 0, two = nums.length - 1;
    for (; one <= two; ) {
      if (nums[one] == 1) {
        one++;
      } else if (nums[one] == 0) {
        swap(nums, one, zero);
        one++;
        zero++;
      } else {
        assert nums[one] == 2;
        swap(nums, two, one);
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

