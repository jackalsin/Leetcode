package airbnb._220_Contains_Duplicate_III;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 8/22/2021
 */
public final class TreeSetSolutionI implements Solution {
  @Override
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    final TreeSet<Integer> visited = new TreeSet<>();
    for (int i = 0; i < nums.length; ++i) {
      final int n = nums[i];
      final int max = (int) Math.min((long) n + t, Integer.MAX_VALUE),
          min = (int) Math.max((long) n - t, Integer.MIN_VALUE);
      final Set<Integer> vals = visited.subSet(min, true, max, true);
      if (!vals.isEmpty()) return true;
      visited.add(n);
      if (i >= k) {
        visited.remove(nums[i - k]);
      }
    }
    return false;
  }
}
