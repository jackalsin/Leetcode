package pinterest._224_Basic_Calculator;

import java.util.Stack;

public final class GenericSolution implements Solution {
  @Override
  public int calculate(String s) {
    int sum = 0, sign = 1;
    final Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        int num = s.charAt(i) - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + (s.charAt(i + 1) - '0'); // 非常骚，容易overflow
          i++;
        }
        sum += sign * num;
      } else if (s.charAt(i) == '+') {
        sign = 1;
      } else if (s.charAt(i) == '-') {
        sign = -1;
      } else if (s.charAt(i) == '(') {
        stack.push(sum);
        stack.push(sign);
        sum = 0;
        sign = 1;
      } else if (s.charAt(i) == ')') {
        sign = stack.pop();
        int preSum = stack.pop();
        sum = preSum + sign * sum;
      }
    }
    return sum;
  }
}
