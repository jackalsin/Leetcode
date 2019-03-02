package interviews.airbnb._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Solution {
  public int calculate(String s) {
    final Deque<int[]> stack = new ArrayDeque<>();
    int l1 = 0, o1 = 1, l2 = 0;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr == ' ') continue;
      if (Character.isDigit(chr)) {
        int num = (chr - '0');
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l1 = l1 + o1 * num;
      } else if (chr == '+') {
        o1 = 1;
      } else if (chr == '-') {
        o1 = -1;
      } else if (chr == '(') {
        stack.push(new int[]{l1, o1});
        l1 = 0;
        o1 = 1;
      } else if (chr == ')') {
        final int[] toRemove = stack.pop();
        l1 = toRemove[0] + toRemove[1] * l1;
      }
    }
    return l1;
  }
}
