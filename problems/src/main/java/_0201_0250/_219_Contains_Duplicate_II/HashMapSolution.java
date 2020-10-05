package _0201_0250._219_Contains_Duplicate_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public final class HashMapSolution implements Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    return hashMapSolution(nums, k);
  }

  private boolean hashMapSolution(int[] nums, int k) {
    Map<Integer, Integer> lastSeen = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      int curDigit = nums[i];
      if (lastSeen.containsKey(curDigit)) {
        int lastSeenPos = lastSeen.get(curDigit);
        if (i - lastSeenPos <= k) {
          return true;
        }
      }
      lastSeen.put(curDigit, i);
    }
    return false;
  }
}
