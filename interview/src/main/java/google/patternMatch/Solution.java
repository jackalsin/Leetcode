package google.patternMatch;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public final class Solution {
  /**
   * 给你一个pattern（pattern中digit表示匹配相应个letter，letter表示匹配letter本身），一个string判断是否match：
   * ex:
   * abc->'abc'
   * '1oc3'->'aoczzz', 'bocabc'
   */
  public boolean patternMatch(final String input, final String pattern) {
    int j = 0;
    for (int i = 0; i < pattern.length(); ) {
      int start = i;
      while (i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
        i++;
      }
      if (i == start) {
        if (input.charAt(j++) != pattern.charAt(i++)) {
          return false;
        }
      } else {
        final String skipStr = pattern.substring(start, i);
        final int skip = Integer.parseInt(skipStr);
        j += skip;
      }
    }
    return true;
  }

}
