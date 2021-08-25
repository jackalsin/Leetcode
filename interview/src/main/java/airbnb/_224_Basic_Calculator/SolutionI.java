package airbnb._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionI implements Solution {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    final Deque<int[]> stack = new ArrayDeque<>();
    int l1 = 0, sign = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l1 += sign * num;
      } else if (chr == '(') {
        stack.push(new int[]{l1, sign});
        l1 = 0;
        sign = 1;
      } else if (chr == ')') {
        final int[] toRemove = stack.pop();
        l1 = toRemove[0] + toRemove[1] * l1;
        sign = 1;
      } else if (chr == '+') {
        sign = 1;
      } else if (chr == '-') {
        sign = -1;
      }
    }
    return l1;
  }
}
