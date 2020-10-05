package uber._291_Word_Pattern_II;

import java.util.HashMap;
import java.util.Map;

public class NaiveSolution implements Solution { // TODO: 搞起
  private final Map<Character, String> patternCharToWord = new HashMap<>();
  private final Map<String, Character> wordToPatternChar = new HashMap<>();

  public boolean wordPatternMatch(String pattern, String str) {
    return wordPatternMatch(pattern, str, 0, 0);
  }

  private boolean wordPatternMatch(final String pattern, final String str,
                                   final int patternIndex, final int strIndex) {
    if (patternIndex >= pattern.length()) {
      return strIndex == str.length();
    }
    final char chr = pattern.charAt(patternIndex);
    if (patternCharToWord.containsKey(chr)) {
      final String expected = patternCharToWord.get(chr);
      if (strIndex + expected.length() <= str.length() && str.startsWith(expected, strIndex)) {
        if (wordToPatternChar.get(expected).equals(chr)) {
          return wordPatternMatch(pattern, str, patternIndex + 1, strIndex + expected.length());
        } else {
          return false;
        }
      } else { // current match failed.
        return false;
      }
    } else {
      for (int i = strIndex + 1; i <= str.length(); i++) {
        final String expected = str.substring(strIndex, i);
        if (wordToPatternChar.containsKey(expected)) {
          if (wordToPatternChar.get(expected) != chr) {
            continue;
          }
        }
        patternCharToWord.put(chr, expected);
        wordToPatternChar.put(expected, chr);
        if (wordPatternMatch(pattern, str, patternIndex + 1, i)) {
          return true;
        }
        patternCharToWord.remove(chr);
        wordToPatternChar.remove(expected);
      }
      return false;
    }
  }
}
