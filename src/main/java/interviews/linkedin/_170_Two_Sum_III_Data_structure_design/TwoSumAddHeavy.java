package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoSumAddHeavy implements TwoSum {

  private final Map<Integer, Integer> elementToCounts;

  public TwoSumAddHeavy() {
    elementToCounts = new HashMap<>();
  }

  @Override
  public void add(int number) {
    elementToCounts.put(number, elementToCounts.getOrDefault(number, 0) + 1);
  }

  @Override
  public boolean find(int value) {
    for (Map.Entry<Integer, Integer> entry : elementToCounts.entrySet()) {
      int key = entry.getKey(), remain = value - key;
      if (key == remain) {
        if (entry.getValue() >= 2) {
          return true;
        }
      } else if (elementToCounts.containsKey(remain)) {
        return true;
      }
    }
    return false;
  }
}
