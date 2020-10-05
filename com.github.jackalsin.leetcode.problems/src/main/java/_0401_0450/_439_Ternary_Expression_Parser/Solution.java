package _0401_0450._439_Ternary_Expression_Parser;

public class Solution {
  private static final char T = 'T', F = 'F';

  public String parseTernary(String expression) {
    return parseTernary(expression, 0, expression.length() - 1);
  }

  /**
   * @param expression
   * @param start      inclusive
   * @param end        inclusive
   * @return
   */
  private static String parseTernary(final String expression, final int start, final int end) {
    if (isValidResult(expression, start, end)) {
      return expression.substring(start, end + 1);
    }

    int count = 1, colonPos = 2;
    for (int i = start + 2; i <= end; i++) {
      if (expression.charAt(i) == '?') {
        count++;
      } else if (expression.charAt(i) == ':') {
        count--;
        if (count == 0) {
          colonPos = i;
          break;
        }
      }
    }

    if (expression.charAt(start) == 'T') {
      return parseTernary(expression, start + 2, colonPos - 1);
    } else {
      return parseTernary(expression, colonPos + 1, end);
    }
  }

  /**
   * Return true when expression.substring(start, end + 1) is <code>T</code>, <code>F</code>, or
   *
   * @param expression
   * @param start
   * @param end
   * @return
   */
  private static boolean isValidResult(String expression, int start, int end) {
    if (end == start) {
      final char chr = expression.charAt(start);
      assert chr == T || chr == F || Character.isDigit(chr);
      return true;
    }
    for (int i = start; i <= end; i++) {
      if (!Character.isDigit(expression.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
