package airbnb._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;
    final char[] chars = s.toCharArray();
    int l1 = 0, o1 = 1;
    final Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < chars.length; ++i) {
      final char c = chars[i];
      if (Character.isDigit(c)) {
        int num = c - '0';
        while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
          num = num * 10 + chars[i + 1] - '0';
        }
        l1 += o1 * num;
      } else if (c == '+') {
        o1 = 1;
      } else if (c == '-') {
        o1 = -1;
      } else if (c == '(') {
        stack.push(new int[]{l1, o1});
      } else if (c == ')') {
        final int[] prev = stack.pop();
        l1 = prev[0] + prev[1] * l1;
        o1 = prev[1];
      }
    }
    return l1;
  }
}
