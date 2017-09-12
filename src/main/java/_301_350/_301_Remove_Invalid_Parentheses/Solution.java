package _301_350._301_Remove_Invalid_Parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/11/2017.
 */
public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    return bfsSolution(s);
  }

  /**
   * This solution is using bfs and visited set
   *
   * Time Complexity:
   * @param s
   * @return
   */
  private static List<String> bfsSolution(String s) {
    List<String> result = new ArrayList<>();
    Queue<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.add(s);
    visited.add(s);
    boolean found = false;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      for (int i = 0; i < size; ++i) {
        final String curString = queue.remove();
        if (isValid(curString)) {
          result.add(curString);
          found = true;
        }
        if (found) continue;
        for (int removeIndex = 0; removeIndex < curString.length(); ++removeIndex) {
          if (curString.charAt(removeIndex) != '(' && curString.charAt(removeIndex) != ')') continue;
          String newString = curString.substring(0, removeIndex)
              + curString.substring(removeIndex + 1);
          if (!visited.contains(newString)) {
            visited.add(newString);
            queue.add(newString);
          }
        }
      }
    }
    return result;
  }

  private static boolean isValid(String string) {
    int positiveCount = 0;
    for (char chr: string.toCharArray()) {
      if (chr == '(') positiveCount++;
      else if (chr == ')') positiveCount--;
      if (positiveCount < 0) return false;
    }
    return positiveCount == 0;
  }
}
