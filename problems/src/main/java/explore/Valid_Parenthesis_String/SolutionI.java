package explore.Valid_Parenthesis_String;

/**
 * @author jacka
 * @version 1.0 on 4/16/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean checkValidString(String s) {
    return checkValidString(s.toCharArray(), 0, 0);
  }

  private static boolean checkValidString(final char[] chars, final int i, final int left) {
    if (left < 0) {
      return false;
    }
    if (i == chars.length) {
      return left == 0;
    }
    final char chr = chars[i];
    boolean result = false;
    if (chr == '*' || chr == '(') {
      result = checkValidString(chars, i + 1, left + 1);
    }
    if (chr == '*' || chr == ')') {
      result |= checkValidString(chars, i + 1, left - 1);
    }
    if (chr == '*') {
      result |= checkValidString(chars, i + 1, left);
    }
    return result;
  }
}
