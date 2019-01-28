package interviews.airbnb._217_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class Solution {
  public boolean containsDuplicate(int[] nums) {
    final Set<Integer> visited = new HashSet<>();
    for (int n : nums) {
      if (visited.contains(n)) {
        return true;
      }
      visited.add(n);
    }
    return false;
  }
}
