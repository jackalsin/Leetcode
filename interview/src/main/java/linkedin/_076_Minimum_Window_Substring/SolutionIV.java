package linkedin._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIV implements Solution {


  /**
   * @param s
   * @param t
   * @return
   */
  @Override
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCount = new HashMap<>();
    for (char chr : t.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }
    int left = 0, minLeft = -1, minLen = Integer.MAX_VALUE, count = charCount.size();
    for (int right = 0; right < s.length(); right++) {
      final char rightChar = s.charAt(right);
      if (charCount.containsKey(rightChar)) {
        final int prevCount = charCount.get(rightChar);
        if (prevCount == 1) {
          count--;
        }
        charCount.put(rightChar, prevCount - 1);

        while (count == 0) {
          final char leftChar = s.charAt(left);
          if (charCount.containsKey(leftChar)) {
            final int preLeftCount = charCount.get(leftChar);
            if (preLeftCount == 0) {
              count++;
            }
            charCount.put(leftChar, preLeftCount + 1);
            final int curLen = right - left + 1;
            if (curLen < minLen) {
              minLen = curLen;
              minLeft = left;
            }
          } // end of if contains
          left++;
        }
      }
    } // end of right for loop

    return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
  }
}
