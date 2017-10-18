package interviews.linkedin._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> visited = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (visited.containsKey(target - nums[i])) {
        return new int[] {i, visited.get(target - nums[i])};
      } else {
        visited.put(nums[i], i);
      }
    }
    throw new IllegalStateException("No solution.");
  }
}
