package oracle._076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String minWindow(String s, String t) {
    final Map<Character, Integer> charCount = getCharCount(t);
    int count = charCount.size();
    final char[] sChars = s.toCharArray();
    int minLeft = -1, minRight = s.length();
    for (int i = 0, left = 0; i < sChars.length; ++i) {
      final char chr = sChars[i];
      if (!charCount.containsKey(chr)) continue;
      final int prevCount = charCount.get(chr);
      if (prevCount == 1) {
        count--;
      }
      charCount.put(chr, prevCount - 1);

      while (count == 0) {
        final char leftChar = sChars[left];
        if (!charCount.containsKey(leftChar)) {
          left++;
          continue;
        }
        int prev = charCount.get(leftChar);
        if (prev == 0) {
          count++;
        }
        charCount.put(leftChar, prev + 1);
        final int cur = i - left + 1;
        if (cur < minRight - minLeft + 1) {
          minLeft = left;
          minRight = i;
        }
        left++;
      }
    }
    return minLeft == -1 ? "" : s.substring(minLeft, minRight + 1);
  }

  private static Map<Character, Integer> getCharCount(String t) {
    final Map<Character, Integer> result = new HashMap<>();
    for (char chr : t.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
