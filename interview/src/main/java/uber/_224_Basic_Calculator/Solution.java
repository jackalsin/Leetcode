package uber._224_Basic_Calculator;

import java.util.Stack;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {
  public int calculate(String s) {
    final Stack<Integer> stack = new Stack<>();
    int sum = 0, curNum = 0, sign = 1;
    final char[] chars = s.toCharArray();
    for (final char chr : chars) {
      if (chr == ' ') {
        continue;
      } else if (chr == '(') {
        stack.push(sum);
        stack.push(sign);
        sign = 1;
        sum = 0;
      } else if (Character.isDigit(chr)) {
        curNum = curNum * 10 + (chr - '0');
      } else if (chr == '+') {
        sum += sign * curNum;
        curNum = 0;
        sign = 1;
      } else if (chr == '-') {
        sum += sign * curNum;
        curNum = 0;
        sign = -1;
      } else if (chr == ')') {
        sum += sign * curNum;
        final int preSign = stack.pop(), num2 = stack.pop();
        sum = preSign * sum + num2;
        curNum = 0;
        sign = 1;
      }
    }
    if (curNum != 0) {
      sum += curNum * sign;
    }
    return sum;
  }

}
