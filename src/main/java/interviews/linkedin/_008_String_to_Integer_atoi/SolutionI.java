package interviews.linkedin._008_String_to_Integer_atoi;

public final class SolutionI implements Solution {
  public int myAtoi(String str) {
    str = str.trim();
    int sign = 1;
    if (str.startsWith("-")) sign = -1;
    if (str.startsWith("-") || str.startsWith("+")) str = str.substring(1);

    if (str.length() == 0) {
      return 0;
    }
    if (!Character.isDigit(str.charAt(0))) {
      return 0;
    }
    int num = 0;
    for (int i = 0; i < str.length(); ++i) {
      final char chr = str.charAt(i);
      final int curDigit = chr - '0';
      if (Character.isDigit(chr)) {
        if (sign == 1) {
          if (num > (Integer.MAX_VALUE / 10)) {
            return Integer.MAX_VALUE;
          } else if (num == Integer.MAX_VALUE / 10 && curDigit >= Integer.MAX_VALUE % 10) {
            return Integer.MAX_VALUE;
          }
          num = num * 10 + curDigit;
        } else { // sign = -1;
          if ((-num < Integer.MIN_VALUE / 10) || (-num == Integer.MIN_VALUE / 10 && curDigit >= Math.abs(Integer.MIN_VALUE % 10))) {
            return Integer.MIN_VALUE;
          }
          num = num * 10 + curDigit;
        }
      } else {
        break;
      }
    }

    return sign * num;
  }

}
