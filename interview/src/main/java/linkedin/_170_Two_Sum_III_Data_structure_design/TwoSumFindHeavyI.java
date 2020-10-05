package linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class TwoSumFindHeavyI implements TwoSum {
  private final Set<Integer> vals = new HashSet<>();
  private final Set<Long> sum = new HashSet<>();

  public void add(int number) {
    for (int i : vals) {
      sum.add((long) i + number);
    }
    vals.add(number);

  }

  public boolean find(int value) {
    return sum.contains((long) value);
  }
}
