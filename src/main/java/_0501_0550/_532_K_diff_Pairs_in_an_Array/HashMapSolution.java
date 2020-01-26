package _0501_0550._532_K_diff_Pairs_in_an_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/26/2020
 */
public final class HashMapSolution implements Solution {
  @Override
  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return 0;
    }
    final Map<Integer, Integer> counts = new HashMap<>();
    int count = 0;
    for (final int num : nums) {
      if (k != 0 && !counts.containsKey(num)) {
        if (counts.containsKey(num - k)) {
          count++;
        }
        if (counts.containsKey(num + k)) {
          count++;
        }
      } else if (k == 0) {
        final int curCount = counts.getOrDefault(num, 0);
        if (curCount == 1) {
          count++;
        }
      }
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    return count;
  }
}
