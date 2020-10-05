package byteDance._031_Next_Permutation;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    // find the first descending
    final int firstDescendingIndex = getFirstDescending(nums);
    if (firstDescendingIndex == 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    final int firstGreaterThanIndex = getFirstGreaterThan(nums, nums[firstDescendingIndex - 1]);
    swap(nums, firstDescendingIndex - 1, firstGreaterThanIndex);
    reverse(nums, firstDescendingIndex, nums.length - 1);
//    System.out.println(Arrays.toString(nums));
  }

  private static int getFirstGreaterThan(final int[] nums, final int target) {
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > target) return i;
    }
    throw new IllegalArgumentException("Element greater than target = " + target + " cannot be found in " + Arrays.toString(nums));
  }

  private static void reverse(final int[] nums, final int start, final int end) {
    for (int i = start, j = end; i < j; ++i, --j) {
      swap(nums, i, j);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private static int getFirstDescending(final int[] nums) {
    int i = nums.length - 1;
    for (; i > 0; --i) {
      if (nums[i - 1] < nums[i]) return i;
    }
    return i;
  }
}
