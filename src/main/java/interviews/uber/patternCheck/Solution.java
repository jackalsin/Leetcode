package interviews.uber.patternCheck;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {
  private static final int INVALID = -1;

  /**
   * https://www.tutorialcup.com/string/check-string-order-characters-pattern-not.htm
   */
  public boolean isMatch(final String src, final String pattern) {
    final int[] charToIndex = new int[26];
    Arrays.fill(charToIndex, INVALID);
    char[] charArray = pattern.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char chr = charArray[i];
      charToIndex[chr - 'a'] = i;
    }

    int preIndexInPattern = -1;
    char[] charArray1 = src.toCharArray();
    for (int i = 0; i < charArray1.length; i++) {
      char chr = charArray1[i];
      int curIndexInPattern = charToIndex[chr - 'a'];
      if (curIndexInPattern == INVALID) {
        continue;
      }
      if (preIndexInPattern != -1 && preIndexInPattern > curIndexInPattern) {
        return false;
      }
      preIndexInPattern = curIndexInPattern;
    }
    return true;
  }
}
