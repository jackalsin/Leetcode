package lime._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class SolutionI implements Solution {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;
    final char[] chars = s.toCharArray();
    final int len = chars.length;
    int res = 0, sign = 1;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < len; ++i) {
      final char chr = chars[i];
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < len && Character.isDigit(chars[i + 1])) {
          num = num * 10 + chars[i + 1] - '0';
          ++i;
        }
        res += sign * num;
      } else if (chr == '(') {
        stack.push(res);
        stack.push(sign);
        res = 0;
        sign = 1;
      } else if (chr == ')') {
        final int prevSign = stack.pop(),
            prevRes = stack.pop();
        res = prevRes + prevSign * res;
      } else if (chr == '+') {
        sign = 1;
      } else if (chr == '-') {
        sign = -1;
      }
    }
    return res;
  }
}
