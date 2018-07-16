package interviews.microsoft._008_String_to_Integer_atoi;

public class Solution {
  private static final int INVALID_RESULT = 0;

  public int myAtoi(String str) {
    str = str.trim();
    if (str.isEmpty()) {
      return INVALID_RESULT;
    }
    int res = 0, sign = 1;
    if (str.charAt(0) == '+') {
      str = str.substring(1);
    } else if (str.charAt(0) == '-') {
      sign = -1;
      str = str.substring(1);
    }
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return res;
      }
      final int digit = str.charAt(i) - '0';
      if (sign == 1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE %
          10)) {
        return Integer.MAX_VALUE;
      }

      if (sign == -1 && (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && digit > -(Integer.MIN_VALUE %
          10))) {
        return Integer.MIN_VALUE;
      }

      res = res * 10 + sign * digit;
    }

    return res;
  }

}
