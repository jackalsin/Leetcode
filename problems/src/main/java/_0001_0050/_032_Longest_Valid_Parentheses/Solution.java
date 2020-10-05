package _0001_0050._032_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2017/2/7.
 */
public class Solution {
  public int longestValidParentheses(String s) {
    if (s == null || s.isEmpty()) return 0;
    Deque<Integer> indexCannotBeMatched = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        indexCannotBeMatched.addLast(i);
      } else {
        if (!indexCannotBeMatched.isEmpty()) {
          if (s.charAt(indexCannotBeMatched.peekLast()) == '(') {
            indexCannotBeMatched.removeLast();
          } else {
            indexCannotBeMatched.addLast(i);
          }
        } else {
          indexCannotBeMatched.addLast(i);
        }
      }
    }
    if (indexCannotBeMatched.isEmpty()) {
      return s.length();
    } else {
      int longestLen = 0, end = s.length();
      while (!indexCannotBeMatched.isEmpty()) {
        int curLen = end - indexCannotBeMatched.peekLast() - 1;
        longestLen = Math.max(longestLen, curLen);
        end = indexCannotBeMatched.removeLast();
      }
      return Math.max(longestLen, end);
    }
  }
}
