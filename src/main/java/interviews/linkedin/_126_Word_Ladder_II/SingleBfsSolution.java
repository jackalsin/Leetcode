package interviews.linkedin._126_Word_Ladder_II;

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
 * @version 1.0 on 6/30/2019
 */
public final class SingleBfsSolution implements Solution {

  public List<List<String>> findLadders(final String beginWord, final String endWord,
                                        final List<String> wordList) {
    final Set<String> wordSet = getWordSet(wordList, beginWord);
    final Map<String, Set<String>> neighbors = getNeighbors(wordSet);
    final Map<String, Integer> distance = getDistance(neighbors, beginWord);
    final List<List<String>> result = new ArrayList<>();
    final List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    dfs(result, neighbors, distance, beginWord, endWord, curPath);
    return result;
  }

  private static Map<String, Integer> getDistance(final Map<String, Set<String>> neighbors, final String beginWord) {
    int distance = 0;
    final Queue<String> q = new ArrayDeque<>();
    final Map<String, Integer> result = new HashMap<>();
    q.add(beginWord);
    result.put(beginWord, 0);
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final String toRemove = q.remove();
        result.put(toRemove, distance);
        final Set<String> nextWords = neighbors.getOrDefault(toRemove, new HashSet<>());
        for (final String next : nextWords) {
          if (result.containsKey(next)) continue;
          result.put(next, distance);
          q.add(next);
        }
      }
      distance++;
    }
    return result;
  }

  private static void dfs(final List<List<String>> result,
                          final Map<String, Set<String>> neighbors,
                          final Map<String, Integer> distances,
                          final String beginWord, final String endWord,
                          final List<String> curPath) {
    if (beginWord.equals(endWord)) {
      if (result.isEmpty()) {
        result.add(new ArrayList<>(curPath));
        return;
      } else {
        final int len = result.get(0).size();
        if (curPath.size() <= len) {
          if (curPath.size() < len) {
            result.clear();
          }
          result.add(new ArrayList<>(curPath));
        }
      }
      return;
    }
    // some optimization
    if (!result.isEmpty() && curPath.size() > result.get(0).size()) {
      return;
    }
    final Set<String> nextWords = neighbors.getOrDefault(beginWord, new HashSet<>());
    for (final String nextWord : nextWords) {
      if (distances.get(nextWord) != curPath.size()) continue;
      curPath.add(nextWord);
      dfs(result, neighbors, distances, nextWord, endWord, curPath);
      curPath.remove(curPath.size() - 1);
    }
  }

  private static Map<String, Set<String>> getNeighbors(final Set<String> wordSet) {
    final Map<String, Set<String>> result = new HashMap<>();
    for (final String word : wordSet) {
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; chr++) {
          if (oldChar == chr) continue;
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            result.computeIfAbsent(word, k -> new HashSet<>()).add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
    return result;
  }

  private static Set<String> getWordSet(final List<String> wordList, final String beginWord) {
    final Set<String> result = new HashSet<>(wordList);
    result.add(beginWord);
    return result;
  }
}
