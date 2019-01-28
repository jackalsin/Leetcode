package interviews.airbnb._220_Contains_Duplicate_III;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    int min = nums[0], max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }

    // create buckets
    final List<Set<Integer>> buckets = new ArrayList<>();
    final int bucketNum = (int) (((long) max - min) / t) + 1;
    for (int i = 0; i < bucketNum; i++) {
      buckets.add(new HashSet<>());
    }

    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        final int becketIndex = getBucketIndex(nums[i - k - 1], min, t);
        buckets.get(becketIndex).remove(nums[i - k - 1]);
      }

      final int bucketIndex = getBucketIndex(nums[i], min, t);
      final Set<Integer> bucket = buckets.get(bucketIndex);
      if (!bucket.isEmpty()) {
        return true;
      } // end of if
      bucket.add(nums[i]);
    }
    return false;
  }

  private static int getBucketIndex(final int num, final int min, final int t) {
    return (int) (((long) num - min) / t);
  }
}
