package linkedin._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public final class SolutionVII implements Solution {
  @Override
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCount = getCharCount(t);
    int minLen = Integer.MAX_VALUE, left = 0, minLeft = -1, uniqueCount = charCount.size();
    for (int right = 0; right < s.length(); ++right) {
      final char rightChar = s.charAt(right);
      if (!charCount.containsKey(rightChar)) continue;
      final int prevCount = charCount.get(rightChar);
      charCount.put(rightChar, prevCount - 1);
      if (prevCount == 1) {
        uniqueCount--;
      }
      while (uniqueCount == 0) {
        final char leftChar = s.charAt(left);
        if (!charCount.containsKey(leftChar)) {
          left++;
          continue;
        }
        charCount.put(leftChar, charCount.get(leftChar) + 1);
        if (charCount.get(leftChar) == 1) {
          uniqueCount++;
        }
        final int curLen = right - left + 1;
        if (curLen < minLen) {
          minLen = curLen;
          minLeft = left;
        }
        left++;
      }
    }
    return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
  }

  private static Map<Character, Integer> getCharCount(final String t) {
    final Map<Character, Integer> result = new HashMap<>();
    final char[] chars = t.toCharArray();
    for (char chr : chars) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}