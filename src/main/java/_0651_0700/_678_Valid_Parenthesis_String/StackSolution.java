package _0651_0700._678_Valid_Parenthesis_String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public final class StackSolution implements Solution {
  @Override
  public boolean checkValidString(String s) {
    /*一个stack track left，一个stack track start
    只要left 小于 star的size，且每一个left stack的index都小于star stack的，
    就是valid
    */
    final Deque<Integer> leftStack = new ArrayDeque<>(),
        starStack = new ArrayDeque<>();
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (chr == '(') {
        leftStack.push(i);
      } else if (chr == '*') {
        starStack.push(i);
      } else {
        if (!leftStack.isEmpty()) {
          leftStack.pop();
        } else if (!starStack.isEmpty()) {
          starStack.pop();
        } else {
          return false;
        }
      }
    }
    if (leftStack.size() > starStack.size()) {
      return false;
    }
    while (!leftStack.isEmpty()) {
      if (starStack.isEmpty()) return false;
      final int toRemove = starStack.pop();
      if (toRemove < leftStack.pop()) {
        return false;
      }
    }
    return true;
  }
}
