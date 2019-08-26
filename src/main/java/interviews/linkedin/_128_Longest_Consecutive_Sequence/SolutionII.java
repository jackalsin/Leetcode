package interviews.linkedin._128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final Map<Integer, Integer> endToEnd = new HashMap<>();
    int max = 0;
    for (int num : nums) {
      if (endToEnd.containsKey(num)) continue;
      final Integer left = endToEnd.get(num - 1), right = endToEnd.get(num + 1);
      if (left == null && right == null) {
        endToEnd.put(num, num);
        max = Math.max(max, 1);
      } else if (left == null) {
        endToEnd.put(num, right);
        endToEnd.put(right, num);
        max = Math.max(max, right - num + 1);
      } else if (right == null) {
        endToEnd.put(num, left);
        endToEnd.put(left, num);
        max = Math.max(max, num - left + 1);
      } else {
        endToEnd.put(num, num);
        endToEnd.put(left, right);
        endToEnd.put(right, left);
        max = Math.max(max, right - left + 1);
      }
    }
    return max;
  }
}
