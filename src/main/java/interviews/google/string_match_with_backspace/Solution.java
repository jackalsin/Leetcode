package interviews.google.string_match_with_backspace;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public final class Solution {
  private static final char BACKSPACE = '\b';

  /**
   * 判断两个包含退格键的字符串是否相同
   */
  public boolean isMatch(final String str1, final String str2) {
    int j = skipBackspace(str2, 0);
    for (int i = skipBackspace(str1, 0); i < str1.length(); ) {
      if (j > str2.length()) {
        return false;
      }
      if (str1.charAt(i++) != str2.charAt(j++)) {
        return false;
      }
      i = skipBackspace(str1, i);
      j = skipBackspace(str2, j);
    }
    return j == str2.length();
  }

  int skipBackspace(final String str, int j) {
    while (j + 1 < str.length() && str.charAt(j + 1) == BACKSPACE) {
      j += 2;
    }
    return j;
  }
}
