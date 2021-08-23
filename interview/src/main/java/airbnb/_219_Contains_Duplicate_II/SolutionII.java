package airbnb._219_Contains_Duplicate_II;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/22/2021
 */
public final class SolutionII implements Solution {
  @Override
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (visited.contains(nums[i])) return true;
      visited.add(nums[i]);
      if (i >= k) {
        visited.remove(nums[i - k]);
      }
    }
    return false;
  }
}
