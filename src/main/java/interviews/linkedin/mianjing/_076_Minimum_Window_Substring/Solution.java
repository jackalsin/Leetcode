package interviews.linkedin.mianjing._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCounts = new HashMap<>();

    for (char chr : t.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }

    int left = 0, minLen = Integer.MAX_VALUE, minLeft = 0, count = charCounts.size();
    for (int right = 0; right < s.length(); ++right) {
      final char rightChar = s.charAt(right);
      if (charCounts.containsKey(rightChar)) {
        final int curCount = charCounts.get(rightChar);
        charCounts.put(rightChar, curCount - 1);
        if (curCount == 1) {
          count--;
        }
      }

      while (count == 0 && left <= right) {
        final char leftChar = s.charAt(left);
        if (charCounts.containsKey(leftChar)) {
          charCounts.put(leftChar, charCounts.get(leftChar) + 1);
          if (charCounts.get(leftChar) > 0) {
            // it can go to negative, so not every time in this block the count can be invalid
            count++;
          }
        }
        final int curLen = right - left + 1;
        if (curLen < minLen) {
          minLen = curLen;
          minLeft = left;
        }
        left++;
      }

    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);

  }

}
