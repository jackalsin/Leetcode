package apple._126_Word_Ladder_II;

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
 * @version 1.0 on 2/15/2021
 */
public final class SolutionI implements Solution {
  private final Set<String> wordSet = new HashSet<>();
  private final List<List<String>> result = new ArrayList<>();
  private final Map<String, Integer> distances = new HashMap<>();
  private final Map<String, Set<String>> neighbors = new HashMap<>();

  public List<List<String>> findLadders(final String beginWord, final String endWord, final List<String> wordList) {
    wordSet.addAll(wordList);
    wordSet.add(beginWord);
    if (!wordSet.contains(endWord)) {
      return result;
    }
    final List<String> curPath = new ArrayList<>() {{
      add(beginWord);
    }};
    generateNeighbors();
    bfsGenerateDistances(beginWord);

    dfs(curPath, beginWord, endWord);
    return result;
  }

  private void dfs(final List<String> curPath, final String start, final String end) {
    if (!result.isEmpty() && result.get(0).size() < curPath.size()) {
      // cur path is already too long
      return;
    }
    if (start.equals(end)) {
      if (!result.isEmpty() && result.get(0).size() > curPath.size()) {
        result.clear();
      }
      result.add(new ArrayList<>(curPath));
      return;
    }
    final int step = curPath.size();
    final Set<String> neighbors = this.neighbors.getOrDefault(start, new HashSet<>());
    for (final String neighbor : neighbors) {
      if (distances.getOrDefault(neighbor, Integer.MAX_VALUE) != step) continue;
      curPath.add(neighbor);
      dfs(curPath, neighbor, end);
      curPath.remove(curPath.size() - 1);
    }
  }

  private void generateNeighbors() {
    for (final String word : wordSet) {
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; chr++) {
          if (chr == oldChar) continue;
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            neighbors.computeIfAbsent(word, k -> new HashSet<>()).add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
  }

  private void bfsGenerateDistances(final String start) {
    int step = 0;
    distances.put(start, 0);
    final Queue<String> q = new ArrayDeque<>() {{
      add(start);
    }};
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        distances.putIfAbsent(toRemove, step);
        for (final String n : neighbors.getOrDefault(toRemove, new HashSet<>())) {
          if (!distances.containsKey(n)) {
            q.add(n);
          }
        }
      }
      step++;
    }
  }
}
