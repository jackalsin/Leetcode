package _0351_0400._384_Shuffle_an_Array;

import java.util.Random;

public class Solution {
  private final int[] nums;
  private final Random random = new Random();

  public Solution(int[] nums) {
    final int n = nums.length;
    this.nums = new int[n];
    System.arraycopy(nums, 0, this.nums, 0, n);
  }

  /**
   * Resets the array to its original configuration and return it.
   */
  public int[] reset() {
    return nums;
  }

  /**
   * Returns a random shuffling of the array.
   */
  public int[] shuffle() {
    /*
     * Using Fisher and Yates Algorithm
     * Proof: https://cs.stackexchange.com/questions/2152/how-to-prove-correctness-of-a-shuffle-algorithm?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
     */
    final int[] res = new int[nums.length];
    System.arraycopy(nums, 0, res, 0, nums.length);
    for (int i = 1; i < nums.length; i++) {
      final int swapIndex = random.nextInt(i + 1);
      swap(res, swapIndex, i);
    }
    return res;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
