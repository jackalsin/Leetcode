package interviews.oracle._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 11/29/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int l1 = 0, o1 = 1, l2 = 0;
    final Deque<int[]> stack = new ArrayDeque<>();
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (chr == ' ') continue;
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
          num = num * 10 + chars[i + 1] - '0';
          i++;
        }
        l2 = num;
      } else if (chr == '+' || chr == '-') {
        l1 += o1 * l2;
        o1 = chr == '+' ? 1 : -1;
        l2 = 0;
      } else if (chr == '(') {
        stack.push(new int[]{l1, o1});
        l1 = 0;
        o1 = 1;
      } else if (chr == ')') {
        l1 += o1 * l2;
        final int[] toRemove = stack.pop();
        l1 = toRemove[0] + toRemove[1] * l1;
        l2 = 0;
        o1 = 1;
      }
    }
    return l1 + o1 * l2;
  }
}
