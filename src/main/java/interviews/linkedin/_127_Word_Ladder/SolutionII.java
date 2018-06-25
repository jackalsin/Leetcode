package interviews.linkedin._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionII implements Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Map<String, Set<String>> neighbors = getNeighbors(wordList, beginWord);

    final Queue<String> q = new ArrayDeque<>();
    final Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int distance = 0;

    q.add(beginWord);
    while (!q.isEmpty()) {
      final int size = q.size();
      distance++;
      for (int i = 0; i < size; i++) {
        final String toRemove = q.remove();
        if (visited.contains(toRemove)) {
          visited.add(toRemove);
          final Set<String> curNeighbors = neighbors.get(toRemove);
          for (final String curNeighbor : curNeighbors) {
            if (curNeighbor.equals(endWord)) {
              return distance + 1;
            }
            if (!visited.contains(curNeighbor)) {
              q.add(curNeighbor);
              visited.add(curNeighbor);
            }
          }
        }
      }
    }
    return 0;
  }

  private static Map<String, Set<String>> getNeighbors(List<String> wordList, String beginWord) {
    final Map<String, Set<String>> result = new HashMap<>();
    final Set<String> words = new HashSet<>(wordList);
    words.add(beginWord);

    for (final String word : words) {
      final char[] chars = word.toCharArray();
      final Set<String> curWordNeighbors = new HashSet<>();
      result.put(word, curWordNeighbors);
      for (int i = 0; i < chars.length; i++) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; chr++) {
          if (chr != oldChar) {
            chars[i] = chr;
            final String newWord = String.valueOf(chars);
            if (words.contains(newWord)) {
              curWordNeighbors.add(newWord);
            }
          }
        } // end of for loop
        chars[i] = oldChar;
      }
    }

    return result;
  }
}
