package interviews.linkedin._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public final class SolutionV implements Solution {

  /**
   * @param s
   * @param t
   * @return
   */
  @Override
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char chr : t.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }

    int minLeft = 0, minLen = Integer.MAX_VALUE, count = charCounts.size(), left = 0;
    final char[] chars = s.toCharArray();
    for (int right = 0; right < chars.length; right++) {
      final char rightChar = chars[right];
      if (charCounts.containsKey(rightChar)) {
        charCounts.put(rightChar, charCounts.get(rightChar) - 1);
        if (charCounts.get(rightChar) == 0) {
          count--;
        }
      } // end of if`

      while (count == 0) {
        final char leftChar = chars[left];
        if (charCounts.containsKey(leftChar)) {
          final int prevCount = charCounts.get(leftChar);
          charCounts.put(leftChar, prevCount + 1);
          if (prevCount == 0) {
            count++;
          }
        }
        final int curLen = (right - left + 1);
        if (curLen < minLen) { // one unique window
          minLen = curLen;
          minLeft = left;
        }
        left++;
      }

    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
  }
}
