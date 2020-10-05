package linkedin._126_Word_Ladder_II;

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
 * @version 1.0 on 8/25/2019
 */
public final class SingleBfsSolutionI implements Solution {
  private final Map<String, List<String>> neighbors = new HashMap<>();
  private final Map<String, Integer> distances = new HashMap<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    final List<List<String>> result = new ArrayList<>();
    if (beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) {
      return result;
    }
    initMap(beginWord, wordList);
    final List<String> curPath = new ArrayList<String>() {{
      add(beginWord);
    }};
    dfs(result, curPath, endWord);
    return result;
  }

  private void dfs(final List<List<String>> result, final List<String> curPath, final String target) {
    final String lastWord = curPath.get(curPath.size() - 1);
    if (lastWord.equals(target)) {
      result.add(new ArrayList<>(curPath));
    }
    if (!result.isEmpty() && result.get(0).size() <= curPath.size()) {
      return;
    }
    final List<String> neighbors = this.neighbors.getOrDefault(lastWord, new ArrayList<>());
    final int targetDistance = curPath.size();
    for (final String word : neighbors) {
      final int dist = this.distances.get(word);
      if (targetDistance != dist) continue;
      curPath.add(word);
      dfs(result, curPath, target);
      curPath.remove(curPath.size() - 1);
    }

  }

  private void initMap(final String beginWord, final List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    getNeighbors(neighbors, wordSet);
    getDistance(beginWord);
  }

  private void getDistance(final String beginWord) {
    final Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    int dist = 0;
    while (!q.isEmpty()) {
      dist++;
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        if (!this.neighbors.containsKey(toRemove)) continue;
        final List<String> neighbors = this.neighbors.get(toRemove);
        for (String next : neighbors) {
          if (distances.containsKey(next)) continue;
          distances.put(next, dist);
          q.add(next);
        }
      }
    }
  }

  private static void getNeighbors(final Map<String, List<String>> neighbors, final Set<String> wordSet) {
    for (final String word : wordSet) {
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; ++chr) {
          if (chr == oldChar) continue;
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            neighbors.computeIfAbsent(word, k -> new ArrayList<>()).add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
  }

}
