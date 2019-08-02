package interviews.linkedin._031_Next_Permutation;

/**
 * @author jacka
 * @version 1.0 on 8/1/2019
 */
public final class SolutionII implements Solution {
  @Override
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    final int firstIndex = getFirstDescending(nums);
    if (firstIndex == 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    final int swapIndex = getLastGreaterThan(nums, nums[firstIndex - 1]);
    swap(nums, swapIndex, firstIndex - 1);
    reverse(nums, firstIndex, nums.length - 1);
//    System.out.println(Arrays.toString(nums));
  }

  private static int getLastGreaterThan(final int[] nums, final int target) {
    int i = nums.length - 1;
    while (nums[i] <= target) {
      i--;
    }
    return i;
  }

  private static void reverse(final int[] nums, final int start, final int end) {
    for (int i = start, j = end; i < j; i++, j--) {
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
    while (i > 0 && nums[i] <= nums[i - 1]) {
      i--;
    }
    return i;
  }
}
