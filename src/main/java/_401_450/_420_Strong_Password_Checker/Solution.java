package _401_450._420_Strong_Password_Checker;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /**
   * A password is considered strong if below conditions are all met:
   * It has at least 6 characters and at most 20 characters.
   * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
   * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
   * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
   *
   * @param s
   * @return
   */
  public int strongPasswordChecker(String s) {
    final char[] sChars = s.toCharArray();
    final List<List<Integer>> repetitionCount = getRepetitionCount(sChars);
    final int l = s.length();
    int toAdd = Math.max(6 - l, 0), toDelete = Math.max(l - 20, 0), actualAdd = 0, actualDelete = 0;
    for (int i = 0; i < repetitionCount.size(); i++) {
      final List<Integer> repetition = repetitionCount.get(i);
      for (int j = 0; j < repetition.size(); j++) {
        if (i < 2) {
          if (actualAdd < toAdd) {
            actualAdd++;

          }

          if (actualDelete < toDelete) {
            actualDelete++;

          }
        }
      }
    }
    return 0;
  }

  private List<List<Integer>> getRepetitionCount(final char[] sChars) {
    final List<List<Integer>> result = new ArrayList<>();
    for (int start = 0; start < sChars.length; ) {
      int end = start;
      while (end < sChars.length && sChars[end] == sChars[start]) {
        end++;
      }
      start = end;
      final int len = end - start;
      if (len >= 3) {
        result.get(len % 3).add(len);
      }
    }
    return result;
  }

}
