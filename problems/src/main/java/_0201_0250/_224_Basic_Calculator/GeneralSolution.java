package _0201_0250._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/2/2019.
 */
public class GeneralSolution {
  public int calculate(String s) {
    final Deque<int[]> stack = new ArrayDeque<>();
    int l1 = 0, sign = 1, num = 0;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr == ' ') continue;
      if (Character.isDigit(chr)) {
        int curNum = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          curNum = curNum * 10 + (s.charAt(i + 1) - '0');
          i++;
        }
        num = curNum;
      } else if (chr == '(') {
        stack.push(new int[]{l1, sign});
        l1 = 0;
        sign = 1;
      } else if (chr == '+') {
        l1 += sign * num;
        sign = 1;
        num = 0;
      } else if (chr == '-') {
        l1 += sign * num;
        sign = -1;
        num = 0;
      } else if (chr == ')') {
        l1 += sign * num;
        final int[] prev = stack.pop();
        l1 = prev[0] + prev[1] * l1;
        sign = 1;
        num = 0;
      }
    }
    return l1 + sign * num;
  }

}
