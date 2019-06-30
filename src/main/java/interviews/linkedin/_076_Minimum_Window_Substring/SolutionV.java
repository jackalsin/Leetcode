package interviews.linkedin._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public final class SolutionV implements Solution {
  /**
   * @param s long
   * @param t short
   * @return
   */
  @Override
  public String minWindow(String s, String t) {
    if (s == null) {
      return "";
    } else if (t == null) {
      return "";
    }
    final Map<Character, Integer> charMap = getCharMap(t);
    int left = 0, size = charMap.size();
    long minLength = Long.MAX_VALUE;
    String minString = "";
    for (int right = 0; right < s.length(); right++) {
      final char chr = s.charAt(right);
      if (charMap.containsKey(chr)) {
        final int beforeCount = charMap.get(chr);
        charMap.put(chr, charMap.get(chr) - 1);
        if (beforeCount == 1) size--;
      }
      while (size == 0) {
        final int curLength = right - left + 1;
        if (curLength < minLength) {
          minLength = curLength;
          minString = s.substring(left, right + 1);
        }
        final char leftChar = s.charAt(left++);
        if (charMap.containsKey(leftChar)) {
          int beforeCount = charMap.get(leftChar);
          if (beforeCount == 0) {
            size++;
          }
          charMap.put(leftChar, beforeCount + 1);
        }
      }
    }
    // here we are mainly stopping the invalid answer.
    return minLength == Long.MAX_VALUE ? "" : minString;
  }

  private static Map<Character, Integer> getCharMap(final String t) {
    final Map<Character, Integer> result = new HashMap<>();
    for (char c : t.toCharArray()) {
      result.put(c, result.getOrDefault(c, 0) + 1);
    }
    return result;
  }
}
