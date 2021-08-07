package linkedin._031_Next_Permutation;

import java.util.Arrays;

public final class SolutionIII implements Solution {
  @Override
  public void nextPermutation(int[] nums) {
    final int firstIndex = firstIndexDecreasing(nums);
    if (firstIndex < 0) {
      reverse(nums);
    } else {
      final int firstGreaterThan = firstGreaterThan(nums, nums[firstIndex]);
      swap(nums, firstGreaterThan, firstIndex);
      reverse(nums, firstIndex + 1, nums.length - 1);
    }
  }

  private static int firstGreaterThan(final int[] nums, final int num) {
    for (int i = nums.length - 1; i >= 0; --i) {
      if (nums[i] > num) return i;
    }
    throw new IllegalStateException("cannot find a val greater than " + num
        + " in " + Arrays.toString(nums));
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private static void reverse(final int[] nums) {
    reverse(nums, 0, nums.length - 1);
  }

  private static void reverse(final int[] nums, final int start, final int end) {
    for (int i = start, j = end; i < j; ++i, --j) {
      swap(nums, i, j);
    }
  }

  private static int firstIndexDecreasing(final int[] nums) {
    int res = nums.length - 2;
    for (; res >= 0; ) {
      if (nums[res + 1] > nums[res]) break;
      res--;
    }
    return res;
  }
}
