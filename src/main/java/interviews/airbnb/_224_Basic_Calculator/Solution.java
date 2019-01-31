package interviews.airbnb._224_Basic_Calculator;

public class Solution {
  public int calculate(String s) {
    return calculate(s, 0, s.length());
  }

  private static int calculate(String s, int start, int end) {
    int l1 = 0, sign = 1, num = 0;
    for (int i = start; i < end; i++) {
      final char chr = s.charAt(i);
      if (chr == ' ') continue;
      if (Character.isDigit(chr)) {
        final int startIndex = i;
        while (i + 1 < end && Character.isDigit(s.charAt(i + 1))) {
          i++;
        }

        num = Integer.parseInt(s.substring(startIndex, i + 1));
        l1 += sign * num;
        sign = 1;
        num = 0;
      } else if (chr == '(') {
        final int startIndex = i;
        int leftCount = 1;
        while (i + 1 < end) {
          final char curChar = s.charAt(i + 1);
          if (curChar == '(') leftCount++;
          else if (curChar == ')') leftCount--;
          if (leftCount == 0) break;
          i++;
        }
        num = calculate(s, startIndex + 1, i + 1);
        l1 += sign * num;
        num = 0;
        sign = 1;
      } else if (chr == '+') {
        sign = 1;
      } else if (chr == '-') {
        sign = -1;
      }
    }
    return l1 + sign * num;
  }
}
