package interviews.linkedin._008_String_to_Integer_atoi;

public final class SolutionII implements Solution {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.isEmpty()) {
      return 0;
    }
    int sign = 1;
    if (str.charAt(0) == '-') {
      sign = -1;
      str = str.substring(1);
    } else if (str.charAt(0) == '+') {
      str = str.substring(1);
    }
    int num = 0;
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        break;
      }
      final int cur = str.charAt(i) - '0';
      if (sign == 1) {
        if (num > Integer.MAX_VALUE / 10 ||
            (num == Integer.MAX_VALUE / 10 && cur >= Integer.MAX_VALUE % 10)) {
          return Integer.MAX_VALUE;
        }
      } else {
        if (num > Integer.MAX_VALUE / 10
            || (num == Integer.MAX_VALUE / 10 && cur >= (Integer.MAX_VALUE % 10 + 1))) {
          return Integer.MIN_VALUE;
        }
      }
      num = num * 10 + cur;
    }
    return sign * num;
  }

}
