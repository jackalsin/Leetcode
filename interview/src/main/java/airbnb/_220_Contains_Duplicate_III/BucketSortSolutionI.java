package airbnb._220_Contains_Duplicate_III;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/22/2021
 */
public final class BucketSortSolutionI implements Solution {
  @Override
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    final Map<Long, Long> buckets = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (i - k - 1 >= 0) {
        final long bucketIndexToRemove = getBucketIndex(nums[i - k - 1], t);
        buckets.remove(bucketIndexToRemove);
      }
      final long bucketIndexToAdd = getBucketIndex(nums[i], t);
      if (buckets.containsKey(bucketIndexToAdd)
          || buckets.containsKey(bucketIndexToAdd - 1) && Math.abs((long) nums[i] - buckets.get(bucketIndexToAdd - 1)) <= t
          || buckets.containsKey(bucketIndexToAdd + 1) && Math.abs((long) nums[i] - buckets.get(bucketIndexToAdd + 1)) <= t
      ) {
        return true;
      }
      buckets.put(bucketIndexToAdd, (long) nums[i]);
    }
    return false;
  }

  private static long getBucketIndex(final int num, final int t) {
    final long diff = (long) num - Integer.MIN_VALUE;
    return diff / ((long) t + 1);
  }
}
