package interviews.linkedin._384_Shuffle_an_Array;

import java.util.Random;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public class Solution {
  private final int[] nums;
  private final Random rand = new Random();

  public Solution(int[] nums) {
    this.nums = new int[nums.length];
    System.arraycopy(nums, 0, this.nums, 0, nums.length);
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
    final int[] res = new int[nums.length];
    System.arraycopy(nums, 0, res, 0, nums.length);
    for (int i = 1; i < nums.length; ++i) {
      final int j = rand.nextInt(i + 1);
      swap(res, i, j);
    }
    return res;
  }

  private static void swap(final int[] res, final int i, final int j) {
    int tmp = res[i];
    res[i] = res[j];
    res[j] = tmp;
  }
}
