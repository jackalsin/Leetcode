package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoSumFindHeavy implements TwoSum {
  private final Set<Integer> sum;
  private final Set<Integer> nums;

  public TwoSumFindHeavy() {
    sum = new HashSet<>();
    nums = new HashSet<>();
  }

  @Override
  public void add(int number) {
    for (int num : nums) {
      sum.add(num + number);
    }
    nums.add(number);
  }

  @Override
  public boolean find(int value) {
    return sum.contains(value);
  }
}
