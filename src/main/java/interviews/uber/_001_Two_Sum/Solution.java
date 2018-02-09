package interviews.uber._001_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> visited = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (visited.containsKey(target - num)) {
        return new int[]{visited.get(target - num), i};
      }
      visited.put(num, i);
    }
    throw new IllegalStateException("No sum pair found in \"" + Arrays.toString(nums) + "\"");
  }
}
