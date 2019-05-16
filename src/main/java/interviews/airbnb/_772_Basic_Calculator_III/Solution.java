package interviews.airbnb._772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Solution {
  public int calculate(String s) {
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    final Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == 1 ? l2 * num : l2 / num;
      } else if (chr == '*') {
        o2 = 1;
      } else if (chr == '/') {
        o2 = -1;
      } else if (chr == '+' || chr == '-') {
        l1 = l1 + o1 * l2;
        l2 = 1;
        o2 = 1;
        o1 = chr == '+' ? 1 : -1;
      } else if (chr == '(') {
        stack.push(new int[]{l1, o1, l2, o2});
        l1 = 0;
        l2 = 1;
        o1 = 1;
        o2 = 1;
      } else if (chr == ')') {
        final int[] toRemove = stack.pop();
        l1 = l1 + o1 * l2;
        l2 = toRemove[3] == 1 ? (l1 * toRemove[2]) : (toRemove[2] / l1);
        l1 = toRemove[0];
        o1 = toRemove[1];
//        o2 not matter
      } else {
        assert chr == ' ';
      }
    }
    return l1 + o1 * l2;
  }
}
