package interviews.linkedin._384_Shuffle_an_Array;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 9/5/2019
 */
public final class SolutionIII implements Solution {
  private final int[] nums;
  private final Random rand = new Random();

  public SolutionIII(final int[] nums) {
    if (nums == null) {
      throw new NullPointerException();
    }
    final int n = nums.length;
    this.nums = new int[n];
    System.arraycopy(nums, 0, this.nums, 0, n);
  }

  public int[] reset() {
    final int[] res = new int[nums.length];
    System.arraycopy(nums, 0, res, 0, nums.length);
    return res;
  }

  public int[] shuffle() {
    final int[] nums = new int[this.nums.length];
    System.arraycopy(this.nums, 0, nums, 0, nums.length);
    for (int i = 1; i < nums.length; ++i) {
      final int toSwapIndex = rand.nextInt(i + 1);
      swap(nums, toSwapIndex, i);
    }
    return nums;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
