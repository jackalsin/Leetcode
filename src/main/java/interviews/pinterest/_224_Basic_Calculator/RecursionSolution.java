package interviews.pinterest._224_Basic_Calculator;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=349668&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public final class RecursionSolution implements Solution {

  public int calculate(String s) {
    return calculate(s, 0, s.length() - 1);
  }

  public int calculate(String s, int sStart, int sEnd) {
//    System.out.println(s.substring(sStart, sEnd + 1));
    int result = 0, sign = 1, value = 0;
    for (int i = sStart; i <= sEnd; i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        value = value * 10 + chr - '0';
      }
      if (chr == '(') {
        int start = i + 1, end = start, count = 1;
        for (; count != 0; end++) {
          final char curEnd = s.charAt(end);
          if (curEnd == '(') {
            count++;
          } else if (curEnd == ')') {
            count--;
          }
        }
        i = end - 1;
        result += sign * calculate(s, start, end - 2);
      } else if (i == sEnd || chr == '+' || chr == '-') {
        result += sign * value;
        value = 0;
        sign = chr == '+' ? 1 : -1;
      }
    }
//    System.out.println(s.substring(sStart, sEnd + 1));
//    System.out.println(result);
    return result;
  }
}
