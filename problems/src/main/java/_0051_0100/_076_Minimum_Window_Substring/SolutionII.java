package _0051_0100._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class SolutionII implements Solution {
  @Override
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (final char c : t.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }
    int left = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();
    for (int right = 0; right < s.length(); right++) {
      final char rightChar = s.charAt(right);
      if (charCounts.containsKey(rightChar)) {
        final int prevCount = charCounts.get(rightChar);
        if (prevCount > 0) {
          count--;
        }
        charCounts.put(rightChar, charCounts.get(rightChar) - 1);
      }

      while (count == 0) {
        int curLen = right - left + 1;
        if (curLen < minLen) {
          minLen = curLen;
          minStart = left;
        }
        final char leftChar = s.charAt(left);
        if (charCounts.containsKey(leftChar)) {
          final int prevLeftCount = charCounts.get(leftChar);
          charCounts.put(leftChar, prevLeftCount + 1);
          if (prevLeftCount == 0) {
            count++;
          }
        }
        left++;
      }

    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }
}
