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
  public boolean isMatch(final String input, final String pattern) {
    final String stack1 = getString(input), stack2 = getString(pattern);
    return stack1.equals(stack2);
  }


  private String getString(final String str) {
    final StringBuilder stack = new StringBuilder();
    for (char chr : str.toCharArray()) {
      if (chr == BACKSPACE) {
        stack.deleteCharAt(stack.length() - 1);
      } else {
        stack.append(chr);
      }
    }
    return stack.toString();
  }

}
