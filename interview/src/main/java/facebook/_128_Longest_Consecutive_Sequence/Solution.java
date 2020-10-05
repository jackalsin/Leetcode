package facebook._128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * TODO: add an documentation
   * https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
   *
   * @param nums
   * @return
   */
  public int longestConsecutive(int[] nums) {
    final Map<Integer, Integer> valToCount = new HashMap<>();
    int maxCount = 0;

    for (int num : nums) {
      if (!valToCount.containsKey(num)) {
        final int left = valToCount.getOrDefault(num - 1, 0),
            right = valToCount.getOrDefault(num + 1, 0);
        int sum = right + left + 1;

        // 1) num is in the mid, valToCount guarantee to have left or right boundary in the key.
        // 2) num is left or right boundary, we are updating the correct value
        if (left != 0 || right != 0) {
          valToCount.put(num, sum);
        }
        maxCount = Math.max(maxCount, sum);
        valToCount.put(num - left, sum);
        valToCount.put(num + right, sum);
      }
    }

    return maxCount;
  }

}
