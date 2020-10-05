package linkedin._128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int longestConsecutive(int[] nums) {
    final Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int cur : nums) {
      if (map.containsKey(cur)) continue; // not skipping can reset the boundary
      //主要是为了防止左右都有boundary的情况，如果此时不放点什么，就会下回来了就没法duplication
      // 会发生上述的问题
      map.put(cur, cur);
      final Integer left = map.get(cur - 1),
          right = map.get(cur + 1);
      if (left == null && right == null) {
        max = Math.max(max, 1);
        map.put(cur, cur);
      } else if (left == null) {
        max = Math.max(max, right - cur + 1);
        map.put(cur, right);
        map.put(right, cur);
      } else if (right == null) {
        max = Math.max(max, cur - left + 1);
        map.put(cur, left);
        map.put(left, cur);
      } else {
        max = Math.max(max, right - left + 1);
        map.put(right, left);
        map.put(left, right);
      }
    }
    return max;
  }
}
