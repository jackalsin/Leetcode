package tableau.removeNotDuplicated;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int removeNotDuplicated(int[] nums) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int n : nums) {
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }
    int end = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (counts.getOrDefault(nums[i], 0) != 1) {
        nums[end++] = nums[i];
      }
    }
    return end;
  }
}
