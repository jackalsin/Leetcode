package airbnb._220_Contains_Duplicate_III;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public final class BucketSortSolution implements Solution {
  @Override
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
      return false;
    }
    final Map<Long, Long> buckets = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        final long removeBucketIndex = getBucketIndex(nums[i - k - 1], t);
        buckets.remove(removeBucketIndex);
      }
      final long bucketIndex = getBucketIndex(nums[i], t);
      if (buckets.containsKey(bucketIndex)
          || (buckets.containsKey(bucketIndex - 1) && (long) nums[i] - buckets.get(bucketIndex - 1) <= t)
          || (buckets.containsKey(bucketIndex + 1) && buckets.get(bucketIndex + 1) - (long) nums[i] <= t)
      ) {
        return true;
      }
      buckets.put(bucketIndex, (long) nums[i]);
    }
    return false;
  }

  private static long getBucketIndex(final int num, final int t) {
    final long remain = (long) num - Integer.MIN_VALUE;
    return remain / ((long) t + 1); // 这里两个都要，t + 1也可能overflow
  }
}
