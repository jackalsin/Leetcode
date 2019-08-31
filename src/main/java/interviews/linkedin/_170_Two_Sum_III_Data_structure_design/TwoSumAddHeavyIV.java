package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class TwoSumAddHeavyIV implements TwoSum {
  private final Map<Integer, Integer> valToCount = new HashMap<>();

  public void add(int number) {
    valToCount.put(number, valToCount.getOrDefault(number, 0) + 1);
  }

  public boolean find(int sum) {
    for (final Map.Entry<Integer, Integer> e : valToCount.entrySet()) {
      final int val = e.getKey(), count = e.getValue();
      if (sum == 2L * val) {
        if (count >= 2) {
          return true;
        }
      } else if (valToCount.containsKey(sum - val)) {
        return true;
      }
    }
    return false;
  }
}
