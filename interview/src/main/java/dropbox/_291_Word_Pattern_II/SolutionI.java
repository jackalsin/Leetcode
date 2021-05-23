package dropbox._291_Word_Pattern_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/22/2021
 */
public final class SolutionI implements Solution {
  private final String[] mapping = new String[128];
  private final Map<String, Character> reverse = new HashMap<>();

  public boolean wordPatternMatch(String pattern, String s) {
    return wordPatternMatch(pattern, s, 0, 0);
  }

  private boolean wordPatternMatch(String pattern, String s,
                                   final int pi, final int si) {
    if (pi == pattern.length()) {
      return si == s.length();
    }
    final char c = pattern.charAt(pi);
    if (mapping[c] != null) {
      if (s.startsWith(mapping[c], si)) {
        final Character expectedChar = reverse.get(mapping[c]);
        if (expectedChar == null || expectedChar != c) return false;
        return wordPatternMatch(pattern, s, pi + 1, si + mapping[c].length());
      }
      return false;
    }
    for (int se = si + 1; se <= s.length(); ++se) {
      final String word = s.substring(si, se);
      final Character expectedChar = reverse.get(word);
      if (expectedChar != null && expectedChar != c) continue;
      reverse.put(word, c);
      mapping[c] = word;
      if (wordPatternMatch(pattern, s, pi + 1, si + word.length())) {
        return true;
      }
      reverse.remove(word);
      mapping[c] = null;
    }
    return false;
  }
}
