package _751_800._772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private static final int PLUS = 1, MINUS = -1, MULTIPLY = 1, DIVIDE = -1;

  public int calculate(String s) {
    //    o1 == 1 means +; o1 == -1 means - ;
    //    o2 == 1 means *; o2 == -1 means /.
    //    By default we have l1 = 0, o1 = 1, and l2 = 1, o2 = 1.

    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == MULTIPLY ? (l2 * num) : (l2 / num);

      } else if (chr == '(') {
        int count = 1, start = ++i;
        // cannot use the following line. i++ will happen before count != 0;
        // for (; count != 0; i++) {
        for (; ; i++) {
          if (s.charAt(i) == '(') {
            count++;
          } else if (s.charAt(i) == ')') {
            count--;
          }
          if (count == 0) break;
        }

        assert (s.charAt(i) == ')');
        int num = calculate(s.substring(start, i));
        l2 = o2 == MULTIPLY ? (l2 * num) : (l2 / num);

      } else if (chr == '*' || chr == '/') {
        o2 = chr == '*' ? MULTIPLY : DIVIDE;
      } else if (chr == '+' || chr == '-') {
        l1 = l1 + o1 * l2;
        o1 = chr == '+' ? PLUS : MINUS;
        l2 = 1;
        o2 = 1;
      }
    }

    return l1 + o1 * l2;
  }
}
