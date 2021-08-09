package linkedin._126_Word_Ladder_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    final Map<String, List<String>> adjacentList = getAdjacentList(wordSet);
    final Map<String, Integer> distances = getDistance(beginWord, adjacentList);
    final List<List<String>> result = new ArrayList<>();
    final List<String> curPath = new ArrayList<>() {{
      add(beginWord);
    }};
    dfs(result, curPath, adjacentList, distances, beginWord, endWord);
    return result;
  }

  private static void dfs(final List<List<String>> result,
                          final List<String> curPath, final Map<String, List<String>> adjacentList,
                          final Map<String, Integer> distances,
                          final String begin, final String target) {
    if (target.equals(begin)) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (final String next : adjacentList.getOrDefault(begin, Collections.emptyList())) {
      if (distances.get(next) == curPath.size()) {
        curPath.add(next);
        dfs(result, curPath, adjacentList, distances, next, target);
        curPath.remove(curPath.size() - 1);
      }
    }
  }

  private static Map<String, Integer> getDistance(final String beginWord,
                                                  final Map<String, List<String>> adjacentList) {
    final Map<String, Integer> result = new HashMap<>() {{
      put(beginWord, 0);
    }};
    final Queue<String> q = new ArrayDeque<>() {{
      add(beginWord);
    }};
    int step = 1;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        for (final String next : adjacentList.getOrDefault(toRemove, Collections.emptyList())) {
          if (result.containsKey(next)) continue;
          result.put(next, step);
          q.add(next);
        }
      }
      step++;
    }
    return result;
  }

  private static Map<String, List<String>> getAdjacentList(Set<String> wordSet) {
    final Map<String, List<String>> result = new HashMap<>();
    for (final String word : wordSet) {
      final char[] chars = word.toCharArray();
      final List<String> neighbors = new ArrayList<>();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; ++chr) {
          if (chr == oldChar) continue;
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            neighbors.add(newWord);
          }
        }
        chars[i] = oldChar;
      }
      result.put(word, neighbors);
    }
    return result;
  }
}
