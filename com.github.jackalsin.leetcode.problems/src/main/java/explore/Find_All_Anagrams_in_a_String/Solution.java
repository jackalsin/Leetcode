package explore.Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    final Map<Character, Integer> charCount = getCharCount(p);
    final Map<Character, Integer> curCount = new HashMap<>();
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      if (i >= p.length()) {
        final char leftChar = s.charAt(i - p.length());
        final int prevCount = curCount.get(leftChar);
        if (prevCount == 1) {
          curCount.remove(leftChar);
        } else {
          curCount.put(leftChar, prevCount - 1);
        }
      }
      final char rightChar = s.charAt(i);
      curCount.put(rightChar, curCount.getOrDefault(rightChar, 0) + 1);
      if (curCount.equals(charCount)) {
        result.add(i - p.length() + 1);
      }
    }
    return result;
  }

  private static Map<Character, Integer> getCharCount(final String p) {
    final Map<Character, Integer> result = new HashMap<>();
    for (final char chr : p.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
