package linkedin._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SingleBfsSolution implements Solution {
  @Override
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (wordList == null) {
      return 0;
    }
    final Set<String> wordSet = new HashSet<>(wordList);
    if (beginWord == null || endWord == null || wordList.isEmpty() || !wordSet.contains(endWord)) {
      return 0;
    }
    final Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    int distance = 1;
    while (!q.isEmpty()) {
      distance++;
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        final List<String> neighbors = getNeighbors(toRemove, wordSet);
        for (final String neighbor : neighbors) {
          if (neighbor.equals(endWord)) {
            return distance;
          }
          if (wordSet.contains(neighbor)) {
            wordSet.remove(neighbor);
            q.add(neighbor);
          }
        }
      }
    }
    return 0;
  }

  private static List<String> getNeighbors(final String word, final Set<String> wordSet) {
    final List<String> result = new ArrayList<>();
    final char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char oldChar = chars[i];
      for (char chr = 'a'; chr <= 'z'; chr++) {
        if (oldChar == chr) continue;
        chars[i] = chr;
        final String newWord = String.valueOf(chars);
        if (wordSet.contains(newWord)) {
          result.add(newWord);
        }
      }
      chars[i] = oldChar;
    }
    return result;
  }
}
