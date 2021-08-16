package airbnb._008_String_to_Integer;

public final class SolutionII implements Solution {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }

    int sign = 1;
    if (str.charAt(0) == '+' || str.charAt(0) == '-') {
      sign = str.charAt(0) == '-' ? -1 : 1;
      str = str.substring(1);
    }

    if (str.length() == 0) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
      final char chr = str.charAt(i);
      final int curDigit = chr - '0';
      if (sign == 1) {
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && curDigit >= (Integer.MAX_VALUE % 10))) {
          return Integer.MAX_VALUE;
        }
      } else {
//        assert sign == -1;
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && curDigit >= 8)) {
          return Integer.MIN_VALUE;
        }
      }
      res = res * 10 + curDigit;
    }
    return sign * res;
  }
}
