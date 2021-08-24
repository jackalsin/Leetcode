package _0201_0250._220_Contains_Duplicate_III;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/14/2017.
 */
public final class BucketSolution implements Solution {
  /**
   * To find out if two distinct indices <code>i</code> and <code>j</code> in the array such that
   * the absolute difference between <code>nums[i]</code> and <code>nums[j]</code> is at most t
   * and the absolute difference between <code>i</code> and <code>j</code> is at most <code>k</code>.
   *
   * @param nums
   * @param k
   * @param t
   * @return
   */
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    return bucketSolution(nums, k, t);
  }

  /**
   * https://discuss.leetcode.com/topic/15199/ac-o-n-solution-in-java-using-buckets-with-explanation/2
   *
   * @param nums
   * @param k
   * @param t
   * @return
   */
  private boolean bucketSolution(int[] nums, int k, int t) {
    if (nums == null || nums.length < 2 || k <= 0 || t < 0) {
      return false;
    }
    Map<Long, Long> buckets = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      long remappingNum = (long) nums[i] - Integer.MIN_VALUE;
      long bucketNum = remappingNum / (long) (t + 1);

      if (buckets.containsKey(bucketNum)
          || (buckets.containsKey(bucketNum - 1)
          && Math.abs(buckets.get(bucketNum - 1) - remappingNum) <= t)
          || (buckets.containsKey(bucketNum + 1)
          && Math.abs(buckets.get(bucketNum + 1) - remappingNum) <= t)) {
        return true;
      }

      if (buckets.size() >= k) {
        long lastBucketNum = ((long) nums[i - k] - Integer.MIN_VALUE) / (long) (t + 1); // t + 1 to avoid divided by 0
        buckets.remove(lastBucketNum);
      }
      buckets.put(bucketNum, remappingNum);
    }
    return false;
  }

}
