package facebook.practice.Minimum_Length_Substrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
public final class SolutionI implements Solution {
  public int minLengthSubstring(String s, String t) {
    final Map<Character, Integer> charsMap = new HashMap<>();
    for (final char c : t.toCharArray()) {
      charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
    }
    final char[] chars = s.toCharArray();
    int minLeft = 0, minRight = s.length(), size = charsMap.size();
    for (int i = 0, left = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (!charsMap.containsKey(chr)) continue;
      final int prevCount = charsMap.get(chr);
      if (prevCount == 1) size--;
      charsMap.put(chr, prevCount - 1);
      while (size == 0) {
        final char leftChar = chars[left];
        if (charsMap.containsKey(leftChar)) {
          final int prev = charsMap.get(leftChar);
          if (prev == 0) {
            size++;
          }
          charsMap.put(leftChar, prev + 1);
          if (minRight - minLeft + 1 > i - left + 1) {
            minRight = i;
            minLeft = left;
          }
        }
        left++;
      }
    }
    return minRight == s.length() ? -1 : minRight - minLeft + 1;
  }
}
