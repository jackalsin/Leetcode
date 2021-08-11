package linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashSet;
import java.util.Set;

public final class TwoSumFindHeavyIV implements TwoSum {
  private final Set<Integer> vals = new HashSet<>(),
      sums = new HashSet<>();

  public void add(int number) {
    for (final int other : vals) {
      sums.add(other + number);
    }
    vals.add(number);
  }

  public boolean find(int value) {
    return sums.contains(value);
  }
}
