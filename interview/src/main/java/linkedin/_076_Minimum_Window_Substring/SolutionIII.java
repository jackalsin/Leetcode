package linkedin._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIII implements Solution {


  /**
   *
   * @param s
   * @param t
   * @return
   */
  @Override
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char c : t.toCharArray()) {
      charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
    }

    int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = t.length();
    for (int right = 0; right < s.length(); ++right) {
      final char rightChar = s.charAt(right);
      if (charCounts.containsKey(rightChar)) {
        charCounts.put(rightChar, charCounts.get(rightChar) - 1);
        if (charCounts.get(rightChar) >= 0) {
          count--;
        }
      }

      while (count == 0) {
        final char leftChar = s.charAt(left);

        if (minLen > right - left + 1) {
          minLeft = left;
          minLen = right - left + 1;
        }
        if (charCounts.containsKey(leftChar)) {
          charCounts.put(leftChar, charCounts.get(leftChar) + 1);
          if (charCounts.get(leftChar) > 0) {
            count++;
          }
        }
        left++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
  }
}
