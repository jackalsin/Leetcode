package interviews.microsoft._020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public boolean isValid(String s) {
    final Deque<Character> stack = new ArrayDeque<>();
    for (char chr : s.toCharArray()) {
      switch (chr) {
        case '{':
        case '[':
        case '(':
          stack.push(chr);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') {
            return false;
          }
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') {
            return false;
          }
          break;
      }
    }
    return stack.isEmpty();
  }
}
