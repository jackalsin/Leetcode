package google._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList) {{
      add(beginWord);
    }};
    final Map<String, List<String>> neighbors = getNeighbors(wordSet);
    if (beginWord.equals(endWord) || !wordSet.contains(endWord)) {
      return 0;
    }
    final Queue<String> q = new ArrayDeque<>() {{
      add(beginWord);
    }};
    final Set<String> visited = new HashSet<>() {{
      add(beginWord);
    }};
    int step = 1;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        if (endWord.equals(toRemove)) return step;
        final List<String> nexts = neighbors.getOrDefault(toRemove, Collections.emptyList());
        for (final String next : nexts) {
          if (!visited.add(next)) continue;
          q.add(next);
        }
      }
      step++;
    }
    return 0;
  }

  private static Map<String, List<String>> getNeighbors(final Set<String> wordSet) {
    final Map<String, List<String>> result = new HashMap<>();
    for (final String word : wordSet) {
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; ++chr) {
          if (oldChar == chr) continue;
          chars[i] = chr;
          final String nextWord = String.valueOf(chars);
          if (wordSet.contains(nextWord)) {
            result.computeIfAbsent(word, k -> new ArrayList<>()).add(nextWord);
          }
        }
        chars[i] = oldChar;
      }
    }
    return result;
  }
}
