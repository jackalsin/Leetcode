package interviews.airbnb._219_Contains_Duplicate_II;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i - k - 1 >= 0) {
        visited.remove(nums[i - k - 1]);
      }
      if (visited.contains(nums[i])) {
        return true;
      }
      visited.add(nums[i]);
    }
    return false;
  }
}
