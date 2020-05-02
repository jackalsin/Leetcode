package interviews.byteDance._003_Longest_Substring_Without_Repeating_Characters;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int lengthOfLongestSubstring(String s) {
    final int[] lastSeen = new int[256];
    Arrays.fill(lastSeen, -1);
    int max = 0, start = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      start = Math.max(lastSeen[chr] + 1, start);
      max = Math.max(max, i - start + 1);
      lastSeen[chr] = i;
    }
    return max;
  }
}
