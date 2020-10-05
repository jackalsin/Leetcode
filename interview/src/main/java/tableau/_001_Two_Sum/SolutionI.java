package tableau._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      final int num = nums[i], remain = target - num;
      if (counts.containsKey(remain)) {
        return new int[]{counts.get(remain), i};
      }
      counts.put(num, i);
    }
    throw new IllegalStateException();
  }
}
