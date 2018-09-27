package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoSumFindHeavyIII implements TwoSum {
  private final Set<Integer> vals = new HashSet<>(), sum = new HashSet<>();

  @Override
  public void add(int number) {
    for (int val : vals) {
      sum.add(val + number);
    }
    vals.add(number);
  }

  @Override
  public boolean find(int value) {
    return sum.contains(value);
  }
}
