package uber._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Map<String, Set<String>> neighbors = generateNeighbors(beginWord, wordList);
    int distance = 1; // begin word distance is 1;
    final Map<String, Integer> distances = new HashMap<>();
    final Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      distance++;

      for (int i = 0; i < size; i++) {
        final String toRemove = queue.remove();
        final Set<String> toRemoveNeighbors = neighbors.get(toRemove);
        for (final String n : toRemoveNeighbors) {
          if (!distances.containsKey(n)) {
            queue.add(n);
            distances.put(n, distance);
            if (endWord.equals(n)) {
              return distance;
            }
          }
        }
      }
    }
    // not found
    return 0;
  }

  private Map<String, Set<String>> generateNeighbors(String beginWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    final Map<String, Set<String>> result = new HashMap<>();
    for (final String word : wordSet) {
      final Set<String> neighbors = result.getOrDefault(word, new HashSet<>());
      final char[] chars = word.toCharArray();

      for (int i = 0; i < chars.length; i++) {
        char oldChar = chars[i];
        for (char newChar = 'a'; newChar <= 'z'; newChar++) {
          if (oldChar != newChar) {
            chars[i] = newChar;
            final String newWord = String.valueOf(chars);
            if (wordSet.contains(newWord)) {
              neighbors.add(newWord);
            }
            chars[i] = oldChar;
          }
        }
      }

      result.put(word, neighbors);
    }
    return result;
  }
}
