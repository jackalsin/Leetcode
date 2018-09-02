package interviews.linkedin.mianjing._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

public final class AddHeavyTwoSum implements TwoSum {
  private final Map<Integer, Integer> valToCount = new HashMap<>();

  /**
   * Add the number to an internal data structure..
   */
  public void add(int number) {
    valToCount.put(number, valToCount.getOrDefault(number, 0) + 1);
  }

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   */
  public boolean find(int value) {
    for (int other : valToCount.keySet()) {
      if (valToCount.containsKey(value - other)) {
        final int count = valToCount.get(value - other);
        if (value == other * 2) {
          if (count > 1) {
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
