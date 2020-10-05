package linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoSumAddHeavyIII implements TwoSum {
  private final Map<Integer, Integer> valueToNumber = new HashMap<>();
  private long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

  @Override
  public void add(int number) {
    min = Math.min(min, number);
    max = Math.max(max, number);
    valueToNumber.put(number, valueToNumber.getOrDefault(number, 0) + 1);
  }

  @Override
  public boolean find(int value) {
    // this block can boost beyond 98.19%
    if (value < min * 2L || max * 2L < value) {
      return false;
    }
    for (final Map.Entry<Integer, Integer> entry : valueToNumber.entrySet()) {
      final int num = entry.getKey(), count = entry.getValue(), other = value - num;
      if (num == other) {
        if (count >= 2) {
          return true;
        }
      } else {
        if (valueToNumber.containsKey(other)) {
          return true;
        }
      }
    }
    return false;
  }
}
