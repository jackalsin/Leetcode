package linkedin.mianjing._127_Word_Ladder;

import java.util.*;

public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);

    final Set<String> visited = new HashSet<>();
    final Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    int distance = 0;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      ++distance;
      for (int i = 0; i < size; ++i) {
        final String toRemove = queue.remove();
        if (endWord.equals(toRemove)) {
          return distance;
        }
        final Set<String> neighbors = getNeighbors(toRemove, wordSet);
        for (String n : neighbors) {
          if (!visited.contains(n)) {
            visited.add(n);
            queue.add(n);
          }
        }
      }
    }
    return 0; // not found
  }

  private static Set<String> getNeighbors(String word, Set<String> wordSet) {
    final Set<String> result = new HashSet<>();
    final char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char oldChar = chars[i];
      for (char c = 'a'; c <= 'z'; c++) {
        if (c != oldChar) {
          chars[i] = c;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            result.add(newWord);
          }
        }
      }
      chars[i] = oldChar;
    }
    return result;
  }
}
