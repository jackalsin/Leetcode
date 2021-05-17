package uber._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.isEmpty() || k <= 0) return 0;
    final char[] chars = s.toCharArray();
    final Map<Character, Integer> charCounts = new HashMap<>();
    int maxLength = 0, left = 0;
    for (int right = 0; right < chars.length; right++) {
      char c = chars[right];
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
      while (charCounts.size() > k) {
        final char leftChar = chars[left];
        final int prevCount = charCounts.get(leftChar);
        if (prevCount == 1) charCounts.remove(leftChar);
        else charCounts.put(leftChar, prevCount - 1);
        left++;
      }
      final int curLen = right - left + 1;
      maxLength = Math.max(curLen, maxLength);
    }
    return maxLength;
  }
}
