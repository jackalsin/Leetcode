package interviews.linkedin._384_Shuffle_an_Array;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class SolutionII implements Solution {
  private final int[] nums;
  private final Random rand = new Random();

  public SolutionII(int[] nums) {
    if (nums == null) {
      throw new NullPointerException();
    }
    this.nums = new int[nums.length];
    System.arraycopy(nums, 0, this.nums, 0, nums.length);
  }

  public int[] reset() {
    return nums;
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
