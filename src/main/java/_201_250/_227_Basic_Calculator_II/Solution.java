package _201_250._227_Basic_Calculator_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
public class Solution {
  public int calculate(String s) {
    int num = 0;
    char sign = '+';
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); ++i) {
      char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        num = 10 * num + (chr - '0');
      }

      if (i == s.length() - 1 || (!Character.isDigit(chr) && chr != ' ')) {
        calculate(stack, sign, num);
        num = 0;
        sign = chr;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }

  private static void calculate(Deque<Integer> stack, char sign, int num) {
    if (sign == '+') {
      stack.push(num);
    } else if (sign == '-') {
      stack.push(-num);
    } else if (sign == '*') {
      stack.push(stack.pop() * num);
    } else if (sign == '/') {
      stack.push(stack.pop() / num);
    }
  }
}
