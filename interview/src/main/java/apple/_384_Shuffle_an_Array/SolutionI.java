package apple._384_Shuffle_an_Array;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
public final class SolutionI implements Solution {
  private final int[] nums, original;
  private final Random rand = new Random();

  public SolutionI(int[] nums) {
    final int n = nums.length;
    this.original = nums;
    this.nums = new int[n];
    System.arraycopy(nums, 0, this.nums, 0, n);
  }

  /**
   * Resets the array to its original configuration and return it.
   */
  public int[] reset() {
    System.arraycopy(original, 0, this.nums, 0, original.length);
    return nums;
  }

  /**
   * Returns a random shuffling of the array.
   */
  public int[] shuffle() {
    for (int i = 1; i < nums.length; ++i) {
      final int toSwap = rand.nextInt(i + 1);
      swap(nums, toSwap, i);
    }
    return nums;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
