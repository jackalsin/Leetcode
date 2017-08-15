package _201_250._219_Contains_Duplicate_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
//    return hashMapSolution(nums, k);
    return hashSetSolution(nums, k);
//    return twoPointersSolution(nums, k);
  }

  /**
   * TODO: Seems wrong
   * @param nums
   * @param k
   * @return
   */
  private boolean twoPointersSolution(int[] nums, int k) {
    if(k == 0) return false;
    int l = 0;
    int r = 1;
    while(r < nums.length) {
      if(l != r && nums[l] == nums[r]) return true;
      if(r - l < k) {
        r++;
      } else if(r - l == k) {
        l++;
      }
    }
    r--;
    while(l < r) {
      if(nums[l++] == nums[r]) {
        return true;
      }
    }
    return false;
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
