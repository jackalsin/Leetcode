package airbnb._008_String_to_Integer;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int myAtoi(String s) {
    if (s == null) return 0;
    s = s.trim();
    if (s.isEmpty()) return 0;
    int sign = 1;
    if (s.charAt(0) == '+' || s.charAt(0) == '-') {
      sign = s.charAt(0) == '+' ? 1 : -1;
      s = s.substring(1);
    }
    int res = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (!Character.isDigit(c)) break;
      final int d = c - '0';
      if (sign > 0 && (res > Integer.MAX_VALUE / 10
          || res == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10)) {
        return Integer.MAX_VALUE;
      }
      if (sign < 0 && (res > Integer.MAX_VALUE / 10
          || res == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10 + 1)) {
        return Integer.MIN_VALUE;
      }
      res = res * 10 + d;
    }
    return sign * res;
  }
}
