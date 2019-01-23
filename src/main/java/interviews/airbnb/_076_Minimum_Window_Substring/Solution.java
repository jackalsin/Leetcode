package interviews.airbnb._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/23/2019.
 */
public class Solution {
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCounts = getCharCounts(t);
    int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = charCounts.size();
    for (int right = 0; right < s.length(); right++) {
      final char rightChar = s.charAt(right);
      if (charCounts.containsKey(rightChar)) {
        final int curCount = charCounts.get(rightChar);
        charCounts.put(rightChar, curCount - 1);
        if (curCount == 1) count--;
      }

      while (count == 0) {
        final char leftChar = s.charAt(left);
        final int curLen = right - left + 1;
        if (minLen > curLen) {
          minLeft = left;
          minLen = curLen;
        }
        left++;

        if (charCounts.containsKey(leftChar)) {
          final int leftCount = charCounts.get(leftChar);
          if (leftCount == 0) {
            count++;
          }
          charCounts.put(leftChar, leftCount + 1);
        }
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
  }

  private static Map<Character, Integer> getCharCounts(String t) {
    final Map<Character, Integer> result = new HashMap<>();
    for (char chr : t.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
