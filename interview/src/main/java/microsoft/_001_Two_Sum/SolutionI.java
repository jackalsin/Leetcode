package microsoft._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI {
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      final int other = target - nums[i];
      if (valToIndex.containsKey(other)) {
        return new int[]{valToIndex.get(other), i};
      }
      valToIndex.put(nums[i], i);
    }
    throw new IllegalStateException("Not found");
  }

}
