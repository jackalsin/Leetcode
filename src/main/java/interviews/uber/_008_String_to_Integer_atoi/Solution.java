package interviews.uber._008_String_to_Integer_atoi;

/**
 * ToDO: submit to leetcode
 */
public class Solution {
  private static final int INVALID_PARSE = 0;

  public int myAtoi(String str) {
    if (str == null) {
      return INVALID_PARSE;
    }
    str = str.trim();

    if (str.isEmpty()) {
      return 0;
    }

    if (str.startsWith("+")) {
      return myAtoi(1, str.substring(1));
    } else if (str.startsWith("-")) {
      return myAtoi(-1, str.substring(1));
    } else {
      return myAtoi(1, str);
    }

  }

  private int myAtoi(int sign, String substring) {
    int res = 0;
    int i = 0;
    while (i < substring.length()) {
      final char chr = substring.charAt(i);
      if (Character.isDigit(chr)) {
        final int digit = chr - '0';
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit >= 8)) {
          return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
          res = res * 10 + digit;
        }
        i++;
      }
    }

    return res * sign;
  }
}
