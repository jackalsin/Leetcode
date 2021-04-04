package lime._772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    final int n = s.length();
    final char[] chars = s.toCharArray();
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1, unaryOp = 0;
    final Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      final char chr = chars[i];
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < n && Character.isDigit(chars[i + 1])) {
          num = num * 10 + chars[i + 1] - '0';
          ++i;
        }
        l2 = o2 == 1 ? l2 * getNum(unaryOp, num) : l2 / getNum(unaryOp, num);
        unaryOp = 1;
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
      } else if (chr == '*') {
        o2 = 1;
        unaryOp = 0;
      } else if (chr == '/') {
        o2 = -1;
        unaryOp = 0;
      } else if (chr == '(') {
        stack.push(new int[]{l1, o1, l2, o2});
        l1 = 0;
        o1 = 1;
        l2 = 1;
        o2 = 1;
        unaryOp = 0;
      } else if (chr == ')') {
        final int[] toRemove = stack.pop();
        final int prevL1 = toRemove[0],
            prevO1 = toRemove[1],
            prevL2 = toRemove[2],
            prevO2 = toRemove[3];
        l2 = prevO2 == 1 ? prevL2 * (l1 + o1 * l2) : prevL2 / (l1 + o1 * l2);
        o2 = 1;
        l1 = prevL1;
        o1 = prevO1;
      }
    }
    return l1 + o1 * l2;
  }

  private static int getNum(final int unaryOp, final int num) {
    if (unaryOp == 0) {
      return num;
    } else {
      return unaryOp * num;
    }
  }
}
