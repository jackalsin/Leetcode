package linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

public final class TwoSumAddHeavyV implements TwoSum {
  private final Map<Integer, Integer> vals = new HashMap<>();

  public void add(int number) {
    vals.put(number, vals.getOrDefault(number, 0) + 1);
  }

  public boolean find(int value) {
    for (final var e : vals.entrySet()) {
      final int a = e.getKey(), count = e.getValue(),
          other = value - a;
      if (other == a) {
        if (count > 1) return true;
      } else if (vals.containsKey(other)) return true;
    }
    return false;
  }
}
