package interviews.byteDance._316_Remove_Duplicate_Letters;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String removeDuplicateLetters(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    final int[] counts = new int[26];
    final char[] chars = s.toCharArray();
    for (char chr : chars) {
      counts[chr - 'a']++;
    }
    final boolean[] visited = new boolean[26];
    final Deque<Character> stack = new ArrayDeque<>();
    for (char chr : chars) {
      counts[chr - 'a']--;
      if (visited[chr - 'a']) continue;
      while (!stack.isEmpty() && stack.peekLast() > chr && counts[stack.peekLast() - 'a'] > 0) {
        final char toRemove = stack.removeLast();
        visited[toRemove - 'a'] = false;
      }
      stack.addLast(chr);
      visited[chr - 'a'] = true;
    }
    final StringBuilder sb = new StringBuilder();
    for (final char chr : stack) {
      sb.append(chr);
    }
    return sb.toString();
  }
}
