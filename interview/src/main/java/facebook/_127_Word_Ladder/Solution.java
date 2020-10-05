package facebook._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList), visited = new HashSet<>();
    wordSet.add(beginWord);
    final Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    visited.add(beginWord);
    int len = 1;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        final String toRemove = queue.remove();
        if (toRemove.equals(endWord)) {
          return len;
        }
        final Set<String> neighbors = getNeighbors(wordSet, toRemove);
        for (String nei : neighbors) {
          if (!visited.contains(nei)) {
            queue.add(nei);
            visited.add(nei);
          }
        }
      }

      len++;
    }

    return 0; // Not Found;
  }

  private static Set<String> getNeighbors(final Set<String> wordSet, final String word) {
    final char[] chars = word.toCharArray();
    final Set<String> result = new HashSet<>();
    for (int i = 0; i < chars.length; i++) {
      final char oldChar = chars[i];
      for (char chr = 'a'; chr <= 'z'; chr++) {
        chars[i] = chr;
        final String newWord = String.valueOf(chars);
        if (!newWord.equals(word) && wordSet.contains(newWord)) {
          result.add(newWord);
        }
      }
      chars[i] = oldChar;
    }
    return result;
  }
}
