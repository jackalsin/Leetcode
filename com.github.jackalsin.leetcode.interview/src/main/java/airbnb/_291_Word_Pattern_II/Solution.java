package airbnb._291_Word_Pattern_II;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
public final class Solution {
  private final String[] map = new String[26];
  private final Set<String> taken = new HashSet<>();

  public boolean wordPatternMatch(String pattern, String str) {
    return wordPatternMatch(pattern, str, 0, 0);
  }

  private boolean wordPatternMatch(String pattern, String str, int patternIndex, int strIndex) {
    if (patternIndex > pattern.length()) {
      return false;
    }
    /* This section below will largely improve the performance*/
    if (pattern.length() - patternIndex > str.length() - strIndex) {
      return false;
    }
    /* This section above will largely improve the performance*/
    if (patternIndex == pattern.length()) {
      return strIndex == str.length();
    }
    final char chr = pattern.charAt(patternIndex);
    final int chrIndex = chr - 'a';
    if (map[chrIndex] != null) {
      final String toMatch = map[chrIndex];
      if (str.startsWith(toMatch, strIndex)) {
        return wordPatternMatch(pattern, str, patternIndex + 1, strIndex + toMatch.length());
      } else {
        return false;
      }
    }

    for (int endIndex = strIndex + 1; endIndex <= str.length(); endIndex++) {
      final String toMatch = str.substring(strIndex, endIndex);
      if (taken.contains(toMatch)) continue;
      map[chrIndex] = toMatch;
      taken.add(toMatch);
      if (wordPatternMatch(pattern, str, patternIndex + 1, strIndex + toMatch.length())) {
        return true;
      }
      map[chrIndex] = null;
      taken.remove(toMatch);
    }
    return false;
  }

}
