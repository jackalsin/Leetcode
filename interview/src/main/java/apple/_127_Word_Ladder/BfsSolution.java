package apple._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/14/2021
 */
public final class BfsSolution implements Solution {
  @Override
  public int ladderLength(final String beginWord, final String endWord, final List<String> wordList) {
    if (beginWord == null) {
      return 0;
    }
    if (beginWord.equals(endWord)) {
      return 1;
    }
    final Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;
    final Queue<String> q = new ArrayDeque<>() {{
      add(beginWord);
    }};
    final Set<String> visited = new HashSet<>() {{
      add(beginWord);
    }};
    int steps = 1;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        final Set<String> neighbors = getNeighbors(wordSet, toRemove);
        for (final String neighbor : neighbors) {
          if (!visited.add(neighbor)) continue;
          if (endWord.equals(neighbor)) {
            return steps + 1;
          }
          q.add(neighbor);
        }
      }
      ++steps;
    }
    return 0;
  }

  private Set<String> getNeighbors(final Set<String> wordSet, final String src) {
    final Set<String> result = new HashSet<>();
    final char[] chars = src.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      final char oldChar = chars[i];
      for (char chr = 'a'; chr <= 'z'; ++chr) {
        if (chr == oldChar) continue;
        chars[i] = chr;
        final String word = String.valueOf(chars);
        if (wordSet.contains(word)) {
          result.add(word);
        }
      }
      chars[i] = oldChar;
    }
    return result;
  }
}
