package uber._772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {
  //TODO: implement
  private static final int PLUS = 1, MINUS = -1, MULTIPLY = 1, DIVIDE = -1;

  public int calculate(String s) {
    int l1 = 0, o1 = PLUS, l2 = 1, o2 = MULTIPLY;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) { // get all number
        int num = s.charAt(i) - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == MULTIPLY ? (l2 * num) : (l2 / num);
        o2 = MULTIPLY;
      } else if (chr == '*') {
        o2 = MULTIPLY;
      } else if (chr == '/') {
        o2 = DIVIDE;
      } else if (chr == '+' || chr == '-') {
        l1 = l1 + o1 * l2;
        o1 = chr == '+' ? PLUS : MINUS;
        l2 = 1;
      } else if (chr == '(') {
        final int start = i;
        int count = 1;
        while (i + 1 < s.length() && count > 0) {
          if (s.charAt(i + 1) == ')') {
            count--;
          } else if (s.charAt(i + 1) == '(') {
            count++;
          }
          i++;
        }
        assert s.charAt(i) == ')';
        int num = calculate(s.substring(start + 1, i));
        l2 = o2 == MULTIPLY ? (l2 * num) : (l2 / num);
        o2 = MULTIPLY;
      }
    }
    return l1 + o1 * l2;
  }
}
