package interviews.pinterest._772_Basic_Calculator_III;

import java.util.Stack;

public final class GenericStackSolutionII implements Solution {
  private static final int ADD = 1, MINUS = -1, MULTI = 1, DIVIDE = -1;

  public int calculate(String s) {
    int l1 = 0, o1 = ADD, l2 = 1, o2 = MULTI;
    final Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = s.charAt(i) - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == MULTI ? l2 * num : l2 / num;
      } else if (chr == '*') {
        o2 = MULTI;
      } else if (chr == '/') {
        o2 = DIVIDE;
      } else if (chr == '+' || chr == '-') {
        l1 += o1 * l2;

        o1 = chr == '+' ? ADD : MINUS;
        o2 = MULTI;
        l2 = 1;
      } else if (chr == '(') {
        stack.push(l1);
        stack.push(o1);
        stack.push(l2);
        stack.push(o2);

        l1 = 0;
        o1 = ADD;
        o2 = MULTI;
        l2 = 1;
      } else if (chr == ')') {
        int num = l1 + l2 * o1;
        o2 = stack.pop();
        l2 = stack.pop();
        o1 = stack.pop();
        l1 = stack.pop();

        l2 = o2 == MULTI ? l2 * num : l2 / num;
      }
    }

    return l1 + l2 * o1;
  }
}
