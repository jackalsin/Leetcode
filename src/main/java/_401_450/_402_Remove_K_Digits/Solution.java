package _401_450._402_Remove_K_Digits;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class Solution {
  /**
   * Given a stack, check if the last one is larger than current char, if yes,
   * @param num
   * @param k
   * @return
   */
  public String removeKdigits(String num, int k) {
    final int length = num.length() - k;
    final Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < num.length(); i++) {
      final char curChar = num.charAt(i);
      while (stack.size() > 0  && stack.peekLast() > curChar && k-- > 0) {
        stack.removeLast();
      }
      stack.addLast(curChar);
    }
    int leading0Counts = 0;
    while (stack.size() > 1 && stack.peekFirst() == '0') {
      stack.removeFirst();
      leading0Counts++;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
        sb.append(stack.removeFirst());
    }
    sb.delete(length - leading0Counts, sb.length());
    return sb.length() == 0 ? "0" : sb.toString();
  }

}
