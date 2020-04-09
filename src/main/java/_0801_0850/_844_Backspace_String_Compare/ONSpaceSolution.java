package _0801_0850._844_Backspace_String_Compare;

/**
 * @author jacka
 * @version 1.0 on 4/9/2020
 */
public final class ONSpaceSolution implements Solution {
  private static final char BACKSPACE = '#';

  public boolean backspaceCompare(String S, String T) {
    if (S == T) {
      return true;
    } else if (S == null || T == null) {
      return false;
    }
    final String stack1 = getString(S),
        stack2 = getString(T);
    return stack1.equals(stack2);
  }

  private static String getString(String s) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == BACKSPACE) {
        final int len = sb.length();
        sb.setLength(Math.max(0, len - 1));
      } else {
        sb.append(chr);
      }
    }
    return sb.toString();
  }
}
