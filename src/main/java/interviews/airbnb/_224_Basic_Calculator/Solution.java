package interviews.airbnb._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Solution {
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final Deque<Integer> stack = new ArrayDeque<>();
    int l1 = 0, sign = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr == ' ') continue;
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l1 = l1 + sign * num;
      } else if (chr == '+' || chr == '-') {
        sign = chr == '+' ? 1 : -1;
      } else if (chr == '(') {
        stack.push(l1);
        stack.push(sign);
        sign = 1;
        l1 = 0;
      } else if (chr == ')') {
        final int prevSign = stack.pop(), prevL1 = stack.pop();
        l1 = prevL1 + prevSign * l1;
        sign = 1;
      }
    }
    return l1;
  }
}
