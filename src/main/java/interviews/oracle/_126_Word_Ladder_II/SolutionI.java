package interviews.oracle._126_Word_Ladder_II;

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
 * @version 1.0 on 11/2/2019
 */
public final class SolutionI implements Solution {
  private final Map<String, Set<String>> adjacentList = new HashMap<>();
  private final Map<String, Integer> distanceMap = new HashMap<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    generateAdjacentList(wordSet);
    generateDistanceMap(beginWord);
    final List<List<String>> result = new ArrayList<>();
    final List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    dfs(result, curPath, beginWord, endWord);
    return result;
  }

  private void dfs(final List<List<String>> result, final List<String> curPath, final String beginWord,
                   final String endWord) {
    if (beginWord.equals(endWord)) {
      if (!result.isEmpty() && result.get(0).size() > curPath.size()) {
        result.clear();
      }
      result.add(new ArrayList<>(curPath));
      return;
    }

    final Set<String> neighbors = adjacentList.getOrDefault(beginWord, new HashSet<>());
    for (String neighbor : neighbors) {
      final int dist = distanceMap.get(neighbor);
      if (dist != curPath.size()) continue;
      curPath.add(neighbor);
      dfs(result, curPath, neighbor, endWord);
      curPath.remove(curPath.size() - 1);
    }
  }

  private void generateDistanceMap(String beginWord) {
    int distance = 0;
    final Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    final Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        distanceMap.put(toRemove, distance);
        final Set<String> nei = adjacentList.getOrDefault(toRemove, new HashSet<>());
        for (String n : nei) {
          if (!visited.contains(n)) {
            visited.add(n);
            q.add(n);
          }
        }
      }
      distance++;
    }
  }

  private void generateAdjacentList(final Set<String> wordSet) {
    for (String word : wordSet) {
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; ++chr) {
          if (chr == oldChar) continue;
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            adjacentList.computeIfAbsent(word, k -> new HashSet<>()).add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
  }
}
