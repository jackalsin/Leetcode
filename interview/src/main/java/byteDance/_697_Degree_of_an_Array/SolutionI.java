package byteDance._697_Degree_of_an_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/23/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int findShortestSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int maxStart = 0, maxEnd = 0, maxCount = 1;
    final Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (map.putIfAbsent(nums[i], new int[]{1, i, i}) != null) {
        final int[] cur = map.get(nums[i]);
        final int count = ++cur[0];
        cur[2] = i;
        if (count > maxCount) {
          maxCount = count;
          maxStart = cur[1];
          maxEnd = cur[2];
        } else if (count == maxCount && maxEnd - maxStart > cur[2] - cur[1]) {
          maxStart = cur[1];
          maxEnd = cur[2];
        }
      }
    }
    return maxEnd - maxStart + 1;
  }
}
