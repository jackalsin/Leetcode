package interviews.pinterest._127_Word_Ladder;

import java.util.*;

public class Solution {
  /**
   * Time Complexity: O(N * len(word) * 26)
   *
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    final Map<String, Set<String>> neighbors = getNeighbors(wordSet);
    final Set<String> visited = new HashSet<>();
    final Queue<String> queue = new ArrayDeque<>();
    int distance = 0;
    queue.add(beginWord);
    visited.add(beginWord);
    /* Time Complexity: O(N) */
    while (!queue.isEmpty()) {
      distance++;
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        final String toRemove = queue.remove();
        final Set<String> toRemoveNeighbors = neighbors.get(toRemove);
        for (String nextWord : toRemoveNeighbors) {
          if (nextWord.equals(endWord)) {
            return distance + 1;
          }
          if (!visited.contains(nextWord)) {
            queue.add(nextWord);
            visited.add(nextWord);
          }
        }
      }

    }

    return 0;
  }

  /**
   * Time Complexity: O(N * len(word) * 26)
   *
   * @param wordSet
   * @return
   */
  private Map<String, Set<String>> getNeighbors(Set<String> wordSet) {
    final Map<String, Set<String>> result = new HashMap<>();
    for (String word : wordSet) {
      final char[] wordArray = word.toCharArray();
      final Set<String> neighbors = new HashSet<>();
      result.put(word, neighbors);
      for (int i = 0; i < word.length(); i++) {
        final char oldChar = word.charAt(i);
        for (char chr = 'a'; chr <= 'z'; chr++) {
          if (oldChar != chr) {
            wordArray[i] = chr;
            final String newWord = String.valueOf(wordArray);
            if (wordSet.contains(newWord)) {
              neighbors.add(newWord);
            }
          }
        }

        wordArray[i] = oldChar;
      }
    }
    return result;
  }
}
