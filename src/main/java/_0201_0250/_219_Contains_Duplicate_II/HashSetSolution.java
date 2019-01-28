package _0201_0250._219_Contains_Duplicate_II;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public final class HashSetSolution implements Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    return hashSetSolution(nums, k);
  }

  private boolean hashSetSolution(int[] nums, int k) {
    Set<Integer> elementsInK = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (i > k) {
        elementsInK.remove(nums[i - k - 1]);
      }
      if (!elementsInK.add(nums[i])) {
        return true;
      }
    }
    return false;
  }

}
