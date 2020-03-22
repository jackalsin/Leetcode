package interviews.google._659_Split_Array_into_Consecutive_Subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isPossible(int[] nums) {
    final Map<Integer, Integer> freqMap = new HashMap<>(),
        appendFreq = new HashMap<>();
    for (int num : nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    for (int num : nums) {
      if (freqMap.get(num) == 0) continue;
      if (appendFreq.getOrDefault(num - 1, 0) > 0) { // append to an existing list
        appendFreq.put(num - 1, appendFreq.get(num - 1) - 1);
        appendFreq.put(num, appendFreq.getOrDefault(num, 0) + 1);
        freqMap.put(num, freqMap.get(num) - 1);
      } else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
        // construct a new list
        freqMap.put(num, freqMap.get(num) - 1);
        freqMap.put(num + 1, freqMap.get(num + 1) - 1);
        freqMap.put(num + 2, freqMap.get(num + 2) - 1);
        appendFreq.put(num + 2, appendFreq.getOrDefault(num + 2, 0) + 1);
      } else {
        return false;
      }
    }
    return true;
  }
}
