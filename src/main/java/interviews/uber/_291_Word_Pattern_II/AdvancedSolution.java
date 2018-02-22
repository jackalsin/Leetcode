package interviews.uber._291_Word_Pattern_II;

import java.util.HashSet;
import java.util.Set;

public class AdvancedSolution implements Solution {
  private static final int N = 26, A = 'a';
  private final String[] patternCharToWord = new String[N];
  private final Set<String> wordAlreadyHasMap = new HashSet<>();

  /**
   * Time Complexity: O(2^N)
   * So, I think T(n) = [ T(1)+T(n-1) ] + [T(2)+T(n-2)] + …
   * T(n-1) = [T(1)+T(n-2)] + …
   * So, T(n) = O(2^n);
   *
   * @param pattern
   * @param str
   * @return
   */
  public boolean wordPatternMatch(String pattern, String str) {
    return wordPatternMatch(pattern, str, 0, 0);
  }

  private boolean wordPatternMatch(final String pattern, final String str,
                                   final int patternIndex, final int strIndex) {
    if (patternIndex >= pattern.length()) {
      return strIndex == str.length();
    }
    final char chr = pattern.charAt(patternIndex);
    if (patternCharToWord[chr - A] != null) {
      final String expected = patternCharToWord[chr - A];
      if (strIndex + expected.length() <= str.length() && str.startsWith(expected, strIndex)) {
        return wordPatternMatch(pattern, str, patternIndex + 1, strIndex + expected.length());
      } else { // current match failed.
        return false;
      }
    } else {
      for (int i = strIndex + 1; i <= str.length(); i++) {
        final String expected = str.substring(strIndex, i);
        if (wordAlreadyHasMap.contains(expected)) {
          continue;
        }
        patternCharToWord[chr - A] = expected;
        wordAlreadyHasMap.add(expected);
        if (wordPatternMatch(pattern, str, patternIndex + 1, i)) {
          return true;
        }
        patternCharToWord[chr - A] = null;
        wordAlreadyHasMap.remove(expected);
      }
      return false;
    }
  }
}
