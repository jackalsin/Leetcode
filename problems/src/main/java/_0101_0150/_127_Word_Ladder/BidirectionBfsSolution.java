package _0101_0150._127_Word_Ladder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/14/2021
 */
public final class BidirectionBfsSolution implements Solution {
  @Override
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null) {
      return 0; // no matter if the other is null or not, it must return 0
    }
    if (beginWord.equals(endWord)) {
      throw new IllegalArgumentException();
    }
    final Set<String> wordSet = new HashSet<>(wordList),
        beginSet = new HashSet<>() {{
          add(beginWord);
        }},
        endSet = new HashSet<>() {{
          add(endWord);
        }};
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    return bfs(beginSet, endSet, wordSet);
  }

  private int bfs(Set<String> beginSet, Set<String> endSet,
                  final Set<String> wordSet) {
    int step = 2;
    final Set<String> visited = new HashSet<>();
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        final Set<String> tmp = endSet;
        endSet = beginSet;
        beginSet = tmp;
      }
//      System.out.println("begin = " + beginSet + ", end = " + endSet);
      final Set<String> nextSet = new HashSet<>();
      for (final String word : beginSet) {
        final char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
          final char oldChar = chars[i];
          for (char chr = 'a'; chr <= 'z'; ++chr) {
            if (oldChar == chr) continue;
            chars[i] = chr;
            final String newWord = String.valueOf(chars);
            if (!wordSet.contains(newWord)) continue;
            if (endSet.contains(newWord)) {
              return step;
            }
            if (visited.add(newWord)) {
              nextSet.add(newWord);
            }
          }
          chars[i] = oldChar;
        }
      }
      beginSet = nextSet;
      step++;
    }
    return 0;
  }
}
