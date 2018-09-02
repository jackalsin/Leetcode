package interviews.linkedin.mianjing._170_Two_Sum_III_Data_structure_design;

import java.util.HashSet;
import java.util.Set;

public final class ReadHeavyTwoSum implements TwoSum {
  private final Set<Integer> originVals = new HashSet<>(), sum = new HashSet<>();

  /**
   * Add the number to an internal data structure..
   */
  public void add(int number) {
    for (int val : originVals) {
      sum.add(number + val);
    }
    originVals.add(number);
  }

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   */
  public boolean find(int value) {
    return sum.contains(value);
  }

}
