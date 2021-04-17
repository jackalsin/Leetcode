package uber.codeSignal._128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class SrcToDstMapSolution implements Solution {
  public int longestConsecutive(int[] nums) {
    int max = 0;
    final Map<Integer, Integer> srcToDst = new HashMap<>();
    for (int num : nums) {
      if (srcToDst.containsKey(num)) continue;
      srcToDst.put(num, num);
      final Integer left = srcToDst.get(num - 1),
          right = srcToDst.get(num + 1);
      if (left == null && right == null) {
        max = Math.max(1, max);
      } else if (left == null) {
        srcToDst.put(num, right);
        srcToDst.put(right, num);
        max = Math.max(max, right - num + 1);
      } else if (right == null) {
        srcToDst.put(left, num);
        srcToDst.put(num, left);
        max = Math.max(max, num - left + 1);
      } else {
        srcToDst.put(left, right);
        srcToDst.put(right, left);
        max = Math.max(max, right - left + 1);
      }
    }
    return max;
  }
}
