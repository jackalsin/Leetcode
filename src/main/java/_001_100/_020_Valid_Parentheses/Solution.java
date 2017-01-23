package _001_100._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public class Solution {
  public boolean isValid(String s) {
    if (s == null) {
      return false;
    } else if (s.isEmpty()) {
      return true;
    } else {
      Deque<Character> stack = new ArrayDeque<>();
      for (int i = 0; i < s.length(); i++) {
        char chr = s.charAt(i);
        switch (chr) {
          case '(':
          case '[':
          case '{':
            stack.addLast(chr);
            break;
          case ']':
            if (stack.isEmpty() || stack.getLast() != '[') {
              return false;
            }
            stack.removeLast();
            break;
          case '}':
            if (stack.isEmpty() || stack.getLast() != '{') {
              return false;
            }
            stack.removeLast();
            break;
          case ')':
            if (stack.isEmpty() || stack.getLast() != '(') {
              return false;
            }
            stack.removeLast();
            break;
          default:
            return false;
        } // end of switch
      }
      return stack.isEmpty();
    }
  }
}
