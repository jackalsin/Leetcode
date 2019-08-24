package interviews.linkedin._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public final class SolutionVII implements Solution {
  @Override
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return "";
    }
    final Map<Character, Integer> charCount = getCharCount(t);
    int count = charCount.size(), left = 0, minLeft = 0, minRight = s.length();
    for (int right = 0; right < s.length(); ++right) {
      final char chr = s.charAt(right);
      if (!charCount.containsKey(chr)) continue;
      charCount.put(chr, charCount.get(chr) - 1);
      if (charCount.get(chr) == 0) {
        count--;
      }
      for (; count == 0; ++left) {
        assert left <= right;
        final char leftChar = s.charAt(left);
        if (!charCount.containsKey(leftChar)) continue;
        if (charCount.get(leftChar) == 0) {
          count++;
        }
        charCount.put(leftChar, charCount.get(leftChar) + 1);
        if (right - left + 1 < minRight - minLeft + 1) {
          minRight = right;
          minLeft = left;
        }
      }
    }
    return minRight == s.length() ? "" : s.substring(minLeft, minRight + 1);
  }

  private static Map<Character, Integer> getCharCount(String t) {
    final Map<Character, Integer> result = new HashMap<>();
    for (final char chr : t.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
