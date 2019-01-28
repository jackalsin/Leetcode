package interviews.airbnb._220_Contains_Duplicate_III;

import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public final class TreeSetSolution implements Solution {
  @Override
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    final TreeSet<Integer> visited = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        visited.remove(nums[i - k - 1]);
      }
      // determine if it's visited
      final Integer max = visited.ceiling(nums[i]), min = visited.floor(nums[i]);
      if ((max != null && (long) max - nums[i] <= t)
          || (min != null && (long) (nums[i]) - min <= t)) {
        return true;
      }
      visited.add(nums[i]);
    }
    return false;
  }
}
