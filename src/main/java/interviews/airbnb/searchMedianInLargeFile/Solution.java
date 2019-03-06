package interviews.airbnb.searchMedianInLargeFile;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
public final class Solution {
  public double findMedian(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length % 2 == 1) {
      return (double) findKthSmallest(nums, nums.length / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    return ((double) findKthSmallest(nums, nums.length / 2, Integer.MIN_VALUE, Integer.MAX_VALUE)
        + findKthSmallest(nums, nums.length / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) / 2;
  }

  /**
   * @param nums
   * @param k
   * @param left
   * @param right
   * @return nums[index]
   */
  private static int findKthSmallest(final int[] nums, final int k, long left, long right) {
    while (left < right) {
      final long mid = (left + right) / 2;
      int count = getLessThanOrEquals(nums, mid);
      if (count < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return (int) left;
  }

  private static int getLessThanOrEquals(final int[] nums, final long target) {
    int count = 0;
    for (int n : nums) {
      if (n <= target) {
        count++;
      }
    }
    return count;
  }

}
