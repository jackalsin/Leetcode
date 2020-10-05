package pinterest._224_Basic_Calculator;

import java.util.Stack;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=349668&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class StackSolution implements Solution {

  public int calculate(String s) {
    int result = 0, sign = 1;
    final Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && (Character.isDigit(s.charAt(i + 1)))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        result += sign * num;
        sign = 1;

      } else if (chr == '+') {
        sign = 1;
      } else if (chr == '-') {
        sign = -1;
      } else if (chr == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (chr == ')') {
        result = result * stack.pop() + stack.pop();
      }
    }
    return result;
  }
}
