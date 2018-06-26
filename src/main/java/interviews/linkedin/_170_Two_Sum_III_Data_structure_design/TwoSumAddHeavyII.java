package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoSumAddHeavyII implements TwoSum {

  private final Map<Integer, Integer> cache;

  public TwoSumAddHeavyII() {
    cache = new HashMap<>();
  }

  @Override
  public void add(int number) {
    cache.put(number, cache.getOrDefault(number, 0) + 1);
  }

  @Override
  public boolean find(int value) {
    for (final Map.Entry<Integer, Integer> entry : cache.entrySet()) {
      int remain = value - entry.getKey();
      if (remain == entry.getKey()) {
        if (entry.getValue() >= 2) {
          return true;
        }
      } else {
        if (cache.containsKey(remain)) {
          return true;
        }
      }
    }
    return false;
  }
}
