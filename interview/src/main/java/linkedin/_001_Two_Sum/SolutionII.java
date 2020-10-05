package linkedin._001_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class SolutionII implements Solution {
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> valueToIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (valueToIndex.containsKey(target - nums[i])) {
        final int j = valueToIndex.get(target - nums[i]);
        return new int[]{j, i};
      }
      valueToIndex.put(nums[i], i);
    }

    throw new IllegalArgumentException("No such pair in " + Arrays.toString(nums));
  }
}
