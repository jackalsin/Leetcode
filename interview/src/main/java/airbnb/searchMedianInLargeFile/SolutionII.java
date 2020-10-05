package airbnb.searchMedianInLargeFile;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
public final class SolutionII implements Solution {
  public double findMedian(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0d;
    }
    if (nums.length % 2 == 0) {
      return (findKthSmallest(nums, nums.length / 2)
          + findKthSmallest(nums, nums.length / 2 + 1)) / 2;
    } else {
      return findKthSmallest(nums, nums.length / 2 + 1);
    }
  }

  /**
   * @param nums input array
   * @param k
   * @return value of the kth smallest in the nums
   */
  private double findKthSmallest(final int[] nums, final int k) {
    long left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
    while (left < right) {
      final int mid = (int) ((right + left) / 2);
      if (count(nums, mid) < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private int count(final int[] nums, final int target) {
    int count = 0;
    for (int n : nums) {
      if (n <= target) {
        count++;
      }
    }
    return count;
  }
}
