package uber._227_Basic_Calculator_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {
  //TODO: implement
  public int calculate(String s) {
    final Deque<Integer> stack = new ArrayDeque<>();
    int num = 0;
    char sign = '+';
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      final char chr = charArray[i];
      if (Character.isDigit(chr)) {
        num = num * 10 + chr - '0';
      }
      if (!Character.isDigit(chr) && chr != ' ' || i == charArray.length - 1) {
        switch (sign) {
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;
          case '*':
            stack.push(stack.pop() * num);
            break;
          case '/':
            stack.push(stack.pop() / num);
            break;
        }
        sign = chr;
        num = 0;
      }
    }
    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }
    return res;
  }

}
