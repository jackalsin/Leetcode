package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoSumAddHeavyIII implements TwoSum {
  private final Map<Integer, Integer> valToCount = new HashMap<>();

  @Override
  public void add(int number) {
    valToCount.put(number, valToCount.getOrDefault(number, 0) + 1);
  }

  @Override
  public boolean find(int sum) {
    for (final Map.Entry<Integer, Integer> entry : valToCount.entrySet()) {
      final int other = entry.getKey(), count = entry.getValue();
      if (valToCount.containsKey(sum - other)) {
        if (sum == other * 2) {
          if (count >= 2) {
            return true;
          }
        } else {
          return true;
        }
      }
    }
    return false;
  }
}
