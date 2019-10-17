package interviews.oracle._217_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/16/2019
 */
public final class SetSolution implements Solution {
  @Override
  public boolean containsDuplicate(int[] nums) {
    final Set<Integer> visited = new HashSet<>();
    for (int num : nums) {
      if (visited.contains(num)) return true;
      visited.add(num);
    }
    return false;
  }
}
