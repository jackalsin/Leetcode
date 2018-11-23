package _0501_0550._525_Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   *
   * @param nums
   * @return
   */
  public int findMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = 0, max = 0;
    final Map<Integer, Integer> preSum = new HashMap<>() {{
      put(0, -1);
    }};
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        nums[i] = -1;
      }
      sum += nums[i];
      if (preSum.containsKey(sum)) {
        max = Math.max(max, i - preSum.get(sum));
      } else {
        preSum.put(sum, i);
      }
    }
    return max;
  }
}
