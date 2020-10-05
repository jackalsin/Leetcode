package tableau.rearrangeOrder;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public void rearrange(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    final int n = nums.length;
    for (int oddIndex = 1, evenIndex = 0; oddIndex < n && evenIndex < n; ) {
      // find not odd one
      while (oddIndex < n && nums[oddIndex] % 2 != 0) {
        oddIndex += 2;
      }
      // find not even
      while (evenIndex < n && nums[evenIndex] % 2 == 0) {
        evenIndex += 2;
      }
      if (evenIndex < n && oddIndex < n) {
        swap(nums, evenIndex, oddIndex);
        evenIndex += 2;
        oddIndex += 2;
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
