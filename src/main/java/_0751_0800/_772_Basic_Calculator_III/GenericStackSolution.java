package _0751_0800._772_Basic_Calculator_III;

import java.util.Stack;

public final class GenericStackSolution implements Solution {
  private static final int PLUS = 1, MINUS = -1, MULTIPLY = 1, DIVIDE = -1;

  /**
   * 68 / 68 test cases passed.
   * Status: Accepted
   * Runtime: 21 ms
   *
   * @param s
   * @return
   */
  public int calculate(String s) {
    //    o1 == 1 means +; o1 == -1 means - ;
    //    o2 == 1 means *; o2 == -1 means /.
    //    By default we have l1 = 0, o1 = 1, and l2 = 1, o2 = 1.
    final Stack<Integer> stack = new Stack<>();
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == MULTIPLY ? (l2 * num) : (l2 / num);

      } else if (chr == '(') {
        stack.push(l1);
        stack.push(o1);
        stack.push(l2);
        stack.push(o2);
        l1 = 0;
        l2 = 1;
        o1 = PLUS;
        o2 = MULTIPLY;
      } else if (chr == ')') {
        int num = l1 + o1 * l2;
        o2 = stack.pop();
        l2 = stack.pop();
        o1 = stack.pop();
        l1 = stack.pop();

        l2 = o2 == MULTIPLY ? l2 * num : l2 / num;

      } else if (chr == '*' || chr == '/') {
        o2 = chr == '*' ? MULTIPLY : DIVIDE;
      } else if (chr == '+' || chr == '-') {
        l1 = l1 + o1 * l2;
        o1 = chr == '+' ? PLUS : MINUS;
        l2 = 1;
        o2 = 1;
      }
    }

    return l1 + o1 * l2;
  }
}
