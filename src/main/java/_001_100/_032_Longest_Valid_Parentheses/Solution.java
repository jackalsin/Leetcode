package _001_100._032_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2017/2/7.
 */
public class Solution {
  public int longestValidParentheses(String s) {
    if (s == null || s.isEmpty()) return 0;
    int maxLen = 0, curLen = 0;
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.addLast('(');
      } else {
        if (!s.isEmpty() && stack.peekLast() == '(') {
          curLen++;
          stack.removeLast();
        } else {
          maxLen = Math.max(maxLen, curLen);
          curLen = 0;
        }
      }
    }
    return maxLen;
  }
}
