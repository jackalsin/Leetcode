package uber._126_Word_Ladder_II;

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
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  private final Map<String, Set<String>> neighbors = new HashMap<>();
  private final Map<String, Integer> distances = new HashMap<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    /* Generate neighbors */
    generateNeighbors(beginWord, wordList);
    /* generate the distance to word*/
    bfsGenerateDistances(beginWord);
    final List<List<String>> result = new ArrayList<>();
    final List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    dfsSearch(result, curPath, beginWord, endWord);
    return result;
  }

  private void dfsSearch(final List<List<String>> result, final List<String> curPath, final String beginWord,
                         final String endWord) {
    if (beginWord.equals(endWord)) {
      result.add(new ArrayList<>(curPath));
    } else {

      final Set<String> curWordNeighbors = neighbors.get(beginWord);
      final int curDepth = curPath.size();
      for (final String word : curWordNeighbors) {
        if (distances.get(word) == curDepth) {
          curPath.add(word);
          dfsSearch(result, curPath, word, endWord);
          curPath.remove(curPath.size() - 1);
        }

      }
    }
  }

  /**
   * Generate the distance to the <code>beginWord</code>
   *
   * @param beginWord
   */
  private void bfsGenerateDistances(final String beginWord) {
    final Queue<String> queue = new ArrayDeque<>();
    int distance = 0;
    queue.add(beginWord);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      distance++;
      for (int i = 0; i < size; i++) {
        final String word = queue.remove();
        final Set<String> curWordNeighbors = neighbors.get(word);
        for (final String neighbor : curWordNeighbors) {
          if (!distances.containsKey(neighbor)) {
            distances.put(neighbor, distance);
            queue.add(neighbor);
          }
        }
      }
    }
  }

  /**
   * Generate the next level neighbors.
   *
   * @param beginWord
   * @param wordList
   */
  private void generateNeighbors(final String beginWord, final List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    for (final String word : wordSet) {
      neighbors.putIfAbsent(word, new HashSet<>());
      final Set<String> curWordSet = neighbors.get(word);
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; chr++) {
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (oldChar != chr && wordSet.contains(newWord)) {
            curWordSet.add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
  }

}
