package linkedin._127_Word_Ladder;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/9/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    if (!wordSet.contains(endWord)) return 0;
    final Map<String, Set<String>> neighbors = getNeighbors(wordSet);
    final Set<String> beginWordSet = new HashSet<>() {{
      add(beginWord);
    }}, endWordSet = new HashSet<>() {{
      add(endWord);
    }};
    assert !beginWord.equals(endWord);
    return bfs(neighbors, beginWordSet, endWordSet);
  }

  private static int bfs(final Map<String, Set<String>> neighbors,
                         Set<String> beginWordSet, Set<String> endWordSet) {
    int step = 2;
    final Set<String> visited = new HashSet<>(beginWordSet);
    while (!beginWordSet.isEmpty() && !endWordSet.isEmpty()) {
      if (beginWordSet.size() > endWordSet.size()) {
        final Set<String> tmp = beginWordSet;
        beginWordSet = endWordSet;
        endWordSet = tmp;
      }
      final Set<String> nextStartSet = new HashSet<>();
      for (final String word : beginWordSet) {
        final Set<String> nextNeighbors = neighbors.getOrDefault(word, Collections.emptySet());
        for (final String next : nextNeighbors) {
          if (endWordSet.contains(next)) return step;
          if (visited.add(next)) {
            nextStartSet.add(next);
          }
        }
      }
      beginWordSet = nextStartSet;
      step++;
    } //  end of while

    return 0;
  }

  private static Map<String, Set<String>> getNeighbors(final Set<String> wordSet) {
    final Map<String, Set<String>> result = new HashMap<>();
    for (final String word : wordSet) {
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char c = 'a'; c <= 'z'; ++c) {
          if (c == oldChar) continue;
          chars[i] = c;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            result.computeIfAbsent(word, k -> new HashSet<>()).add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
    return result;
  }
}
