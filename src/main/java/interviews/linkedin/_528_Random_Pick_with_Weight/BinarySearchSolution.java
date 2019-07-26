package interviews.linkedin._528_Random_Pick_with_Weight;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 7/25/2019
 */
public final class BinarySearchSolution implements Solution {
  private final int[] sums;
  private final int sum;
  private final Random rand = new Random();

  public BinarySearchSolution(final int[] w) {
    if (w == null) {
      sum = 0;
      sums = null;
      return;
    }
    int sum = 0;
    sums = new int[w.length];
    for (int i = 0; i < w.length; i++) {
      sum += w[i];
      sums[i] = sum;
    }
    this.sum = sum;
  }

  /**
   * @param nums
   * @param target
   * @return index
   */
  private int getFirstGreaterThan(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    assert (nums[left] > target);
    return left;
  }

  @Override
  public int pickIndex() {
    if (sums == null) {
      return 0;
    }
    final int pick = rand.nextInt(sum);
    return getFirstGreaterThan(sums, pick);
  }
}
