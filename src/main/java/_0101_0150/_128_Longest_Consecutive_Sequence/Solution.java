package _0101_0150._128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {

  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> edgeToLength = new HashMap<>();
    int sum = 0;
    for (int i : nums) {
      if (!edgeToLength.containsKey(i)) {
        int left = edgeToLength.getOrDefault(i - 1, 0);
        int right = edgeToLength.getOrDefault(i + 1, 0);
        int curSum = left + right + 1;
        edgeToLength.put(i, curSum);
        sum = Math.max(curSum, sum);

        // extend the edge length
        edgeToLength.put(i - left, curSum);
        edgeToLength.put(i + right, curSum);

      }
    }
    return sum;
  }
}
