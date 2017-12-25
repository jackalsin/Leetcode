package _601_650._644_Maximum_Average_Subarray_II;

/**
 * @author jacka
 * @version 1.0 on 12/25/2017.
 * Time Complexity O(n * log(MaxValue - MinValue))
 */
public class BinarySearchSolution implements Solution {
  private static final double STEP = 1e-5;

  @Override
  public double findMaxAverage(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) {
      return Integer.MAX_VALUE;
    }
    double min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
    while (min <= max) {
      double mid = (max - min) / 2.0 + min;
      if (hasAboveAverage(nums, k, mid)) {
        min = mid + STEP;
      } else {
        max = mid - STEP;
      }
    }
    return max;
  }

  private static boolean hasAboveAverage(final int[] nums, final int k, double average) {
    double kSum = 0, extraSum = 0;
    for (int i = 0; i < k; i++) {
      kSum += nums[i] - average;
    }
    if (kSum >= 0) {
      return true;
    }
    // must have at least k elements; the nums before the last k element should be kept if their
    // sum > 0;
    // else we should remove them from the current sum (equivalent to update the start position)
    int cur = k;
    while (cur < nums.length) {
      kSum += nums[cur] - average;
      extraSum += nums[cur - k] - average; // extraSum: the sum before
      if (extraSum < 0) {
        kSum -= extraSum;
        extraSum = 0;
      }
      if (kSum >= 0) {
        return true;
      }
      cur++;
    }
    return false;
  }
}
