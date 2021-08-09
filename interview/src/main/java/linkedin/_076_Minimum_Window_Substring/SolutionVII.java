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
    if (s == null || t == null) return s;
    final char[] sChars = s.toCharArray(), tChars = t.toCharArray();
    final Map<Character, Integer> charMap = new HashMap<>();
    for (final char c : tChars) charMap.put(c, charMap.getOrDefault(c, 0) + 1);
    int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = charMap.size();
    for (int right = 0; right < s.length(); ++right) {
      final char chr = sChars[right];
      if (!charMap.containsKey(chr)) continue;
      charMap.put(chr, charMap.get(chr) - 1);
      if (charMap.get(chr) == 0) count--;
      while (count == 0) {
        final char leftChar = sChars[left];
        if (charMap.containsKey(leftChar)) {
          final int prevCount = charMap.get(leftChar);
          if (prevCount == 0) count++;
          charMap.put(leftChar, prevCount + 1);
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