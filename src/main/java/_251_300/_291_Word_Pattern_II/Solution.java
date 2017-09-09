package _251_300._291_Word_Pattern_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jackal
 * @version 1.0 on 9/6/2017.
 */
public class Solution {
  /**
   * Given a pattern and a string str, find if str follows the same pattern.
   * Here follow means a full match, such that there is a bijection between a letter in pattern
   * and a non-empty substring in str.
   * Examples:
   * pattern = "abab", str = "redblueredblue" should return true.
   * pattern = "aaaa", str = "asdasdasdasd" should return true.
   * pattern = "aabb", str = "xyzabcxzyabc" should return false.
   * Notes:
   * You may assume both pattern and str contains only lowercase letters.
   * @param pattern
   * @param str
   * @return
   */
  public boolean wordPatternMatch(String pattern, String str) {
    final Map<Character, String> patternCharacterToString = new HashMap<>();
    final Set<String> hasMapping = new HashSet<>();
    return isMatch(patternCharacterToString, hasMapping, pattern, str, 0, 0);
  }

  private boolean isMatch(final Map<Character, String> patternCharacterToString, final
    Set<String> hasMapping, final String pattern, final String str, int patternIndex, int strIndex) {

    if (patternIndex == pattern.length() && strIndex == str.length()) return true;
    if (patternIndex == pattern.length() || strIndex == str.length()) return false;
    final char patternChar = pattern.charAt(patternIndex);
    String supposePattern = patternCharacterToString.get(patternChar);
    if (supposePattern == null) { // new
      for (int endIndex = strIndex + 1; endIndex <= str.length(); ++endIndex) {
        final String curPattern = str.substring(strIndex, endIndex);
        if (!hasMapping.add(curPattern)) continue;
        patternCharacterToString.put(patternChar, curPattern);
        if (isMatch(patternCharacterToString, hasMapping, pattern, str,
            patternIndex + 1, endIndex)) {
          return true;
        }
        hasMapping.remove(curPattern);
        patternCharacterToString.remove(patternChar);
      }
      return false;
    } else {
      if (strIndex + supposePattern.length() <= str.length()
          && supposePattern.equals(str.substring(strIndex, strIndex + supposePattern.length())
      )) {
        return isMatch(patternCharacterToString, hasMapping, pattern, str,
            patternIndex + 1, strIndex + supposePattern.length());
      } else {
        return false;
      }
    }
  }
}
