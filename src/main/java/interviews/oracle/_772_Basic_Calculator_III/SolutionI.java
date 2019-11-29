package interviews.oracle._772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhixi
 * @version 1.0 on 11/28/2019
 */
public final class SolutionI implements Solution {

  @Override
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final char[] chars = s.toCharArray();
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1, unaryOp = 0; // 0 means not met a number
    final Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (chr == ' ') {
        continue;
      } else if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
          num = num * 10 + chars[i + 1] - '0';
          ++i;
        }
        l2 = o2 == 1 ? l2 * getNumber(unaryOp, num) : l2 / getNumber(unaryOp, num);
        unaryOp = 1;
      } else if (chr == '*') {
        o2 = 1;
        unaryOp = 0;
      } else if (chr == '/') {
        o2 = -1;
        unaryOp = 0;
      } else if (chr == '+' || chr == '-') {
        if (unaryOp == 0) {
          unaryOp = chr == '+' ? 1 : -1;
        } else {
          l1 += o1 * l2;
          o1 = chr == '+' ? 1 : -1;
          l2 = 1;
          o2 = 1;
          unaryOp = 0;
        }
      } else if (chr == '(') {
        stack.push(new int[]{l1, o1, l2, o2});
        l1 = 0;
        o1 = 1;
        l2 = 1;
        o2 = 1;
        unaryOp = 0;
      } else if (chr == ')') {
        final int[] prev = stack.pop();
        l1 += o1 * l2;
        o2 = prev[3];
        l2 = o2 == 1 ? prev[2] * l1 : prev[2] / l1;
        l1 = prev[0];
        o1 = prev[1];
      } else {
        throw new IllegalArgumentException("char " + chr);
      }
    }
    return l1 + o1 * l2;
  }

  private static int getNumber(final int prevOp, final int num) {
    if (prevOp == 0) {
      return num;
    } else {
      return prevOp * num;
    }
  }
}
