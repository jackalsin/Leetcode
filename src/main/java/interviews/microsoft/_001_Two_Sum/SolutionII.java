package interviews.microsoft._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public final class SolutionII {
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> valToIndex = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      if (valToIndex.containsKey(target - nums[i])) {
        return new int[]{valToIndex.get(target - nums[i]), i};
      }
      valToIndex.put(nums[i], i);
    }
    throw new IllegalStateException();
  }

}
