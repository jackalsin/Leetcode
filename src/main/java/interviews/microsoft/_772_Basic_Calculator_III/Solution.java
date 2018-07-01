package interviews.microsoft._772_Basic_Calculator_III;

import java.util.Stack;

public class Solution {
  public int calculate(String s) {
    final Stack<Integer> stack = new Stack<>();
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int val = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          val = val * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        // divide
        l2 = o2 == 1 ? (l2 * val) : (l2 / val);
      } else if (chr == '+' || chr == '-') {
        l1 = l1 + o1 * l2;
        o1 = chr == '+' ? 1 : -1;
        o2 = 1;
        l2 = 1;
      } else if (chr == '*') {
        o2 = 1;
      } else if (chr == '/') {
        o2 = -1;
      } else if (chr == '(') {
        stack.push(l1);
        stack.push(o1);
        stack.push(l2);
        stack.push(o2);
        l1 = 0;
        o1 = 1;
        o2 = 1;
        l2 = 1;
      } else if (chr == ')') {
        final int num = l1 + o1 * l2;
        o2 = stack.pop();
        l2 = stack.pop();
        o1 = stack.pop();
        l1 = stack.pop();
        l2 = o2 == 1 ? num * l2 : l2 / num;
      }
    }

    // return result; l1 related

    return l1 + l2 * o1;
  }
}
