package linkedin._008_String_to_Integer_atoi;

public final class SolutionIII implements Solution {
  private static final char PLUS = '+', MINUS = '-';

  public int myAtoi(String str) {
    str = str.trim();
    if (str.isEmpty()) return 0;
    int sign = 1;
    final char first = str.charAt(0);
    if (first != PLUS && first != MINUS && !Character.isDigit(first)) return 0;
    int start = 0;
    if (first == MINUS || first == PLUS) {
      sign = first == MINUS ? -1 : 1;
      start = 1;
    }
    int num = 0;
    for (; start < str.length(); ++start) {
      final char chr = str.charAt(start);
      if (!Character.isDigit(chr)) break;
      final int cur = chr - '0';
      if (sign == 1) {
        if (num > Integer.MAX_VALUE / 10 ||
            (num == Integer.MAX_VALUE / 10 && cur >= Integer.MAX_VALUE % 10))
          return Integer.MAX_VALUE;
      } else {
        if (num > Integer.MAX_VALUE / 10 ||
            (num == Integer.MAX_VALUE / 10 && cur >= Integer.MAX_VALUE % 10 + 1))
          return Integer.MIN_VALUE;
      }
      num = num * 10 + cur;
    }
    return sign * num;
  }
}
