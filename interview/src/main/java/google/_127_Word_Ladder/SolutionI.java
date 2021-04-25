package google._127_Word_Ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
public final class SolutionI implements Solution {
  private final Set<String> wordSet = new HashSet<>();

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    wordSet.addAll(wordList);
    wordSet.add(beginWord);
    if (beginWord.equals(endWord) || !wordSet.contains(endWord)) {
      return 0;
    }
    final Set<String> beginSet = new HashSet<>() {{
      add(beginWord);
    }}, endSet = new HashSet<>() {{
      add(endWord);
    }};
    return bfs(beginSet, endSet);
  }

  private int bfs(Set<String> beginSet, Set<String> endSet) {
    int step = 1;
    final Set<String> visited = new HashSet<>();
    visited.addAll(beginSet);
    visited.addAll(endSet);
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        final Set<String> tmp = beginSet;
        beginSet = endSet;
        endSet = tmp;
      }
      final Set<String> next = new HashSet<>();
      for (final String cur : beginSet) {
        final List<String> neighborList = getNeighbors(cur);
        for (final String n : neighborList) {
          if (endSet.contains(n)) return step + 1;
          if (!visited.add(n)) continue;
          next.add(n);
        }
      }
      step++;
      beginSet = next;
    }

    return 0;
  }

  private List<String> getNeighbors(final String cur) {
    final List<String> result = new ArrayList<>();
    final char[] chars = cur.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char old = chars[i];
      for (char c = 'a'; c <= 'z'; ++c) {
        if (c == old) continue;
        chars[i] = c;
        final String nextWord = String.valueOf(chars);
        if (wordSet.contains(nextWord)) {
          result.add(nextWord);
        }
      }
      chars[i] = old;
    }
    return result;
  }

}
