package linkedin._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class SolutionII implements Solution {
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      final int remain = target - nums[i];
      if (valToIndex.containsKey(remain)) {
        final int j = valToIndex.get(remain);
        return new int[]{j, i};
      }
      valToIndex.put(nums[i], i);
    }
    throw new IllegalStateException("Unable to find");
  }
}
