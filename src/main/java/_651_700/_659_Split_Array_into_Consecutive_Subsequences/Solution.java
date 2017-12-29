package _651_700._659_Split_Array_into_Consecutive_Subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/28/2017.
 */
public class Solution {
  /**
   * Time complexity O (N), Space O(N)
   */
  public boolean isPossible(int[] nums) {
    final Map<Integer, Integer> freq = new HashMap<>(), appendFreq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    for (int num : nums) {
      if (freq.get(num) == 0) {
        continue;
      } else if (appendFreq.getOrDefault(num, 0) > 0) { // able to add to a previous list.
        appendFreq.put(num, appendFreq.get(num) - 1);
        appendFreq.put(num + 1, appendFreq.getOrDefault(num + 1, 0) + 1);
      } else if (freq.getOrDefault(num + 1, 0) > 0
          && freq.getOrDefault(num + 2, 0) > 0) {
        freq.put(num + 1, freq.get(num + 1) - 1);
        freq.put(num + 2, freq.get(num + 2) - 1);
        appendFreq.put(num + 3, appendFreq.getOrDefault(num + 3, 0) + 1);
      } else {
        return false;
      }
      freq.put(num, freq.get(num) - 1);
    }
    return true;
  }
}
