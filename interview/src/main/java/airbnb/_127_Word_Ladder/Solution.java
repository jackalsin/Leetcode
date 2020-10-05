package airbnb._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Map<String, List<String>> neighbors = getNeighbors(beginWord, wordList);
    final Queue<String> q = new ArrayDeque<>();
    final Set<String> visited = new HashSet<>();
    if (endWord.equals(beginWord)) {
      return 1;
    }
    int dist = 1;
    q.add(beginWord);
    visited.add(beginWord);

    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final String toRemove = q.remove();
        final List<String> curNeighbors = neighbors.getOrDefault(toRemove, new ArrayList<>());
        for (String nextWord : curNeighbors) {
          if (visited.contains(nextWord)) continue;
          visited.add(nextWord);
          if (endWord.equals(nextWord)) {
            return dist + 1;
          }
          q.add(nextWord);
        }
      }
      dist++;
    }

    return 0;
  }

  private static Map<String, List<String>> getNeighbors(final String beginWord, final List<String> wordList) {
    final Map<String, List<String>> result = new HashMap<>();
    final Set<String> words = new HashSet<>(wordList);
    words.add(beginWord);
    for (final String word : words) {
      final char[] chars = word.toCharArray();
      final List<String> neighbors = new ArrayList<>();
      result.put(word, neighbors);
      for (int i = 0; i < chars.length; i++) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; chr++) {
          if (chr != oldChar) {
            chars[i] = chr;
            final String newWord = String.valueOf(chars);
            if (words.contains(newWord)) {
              neighbors.add(newWord);
            }
          }
        }
        chars[i] = oldChar;
      }
    }
    return result;
  }
}
