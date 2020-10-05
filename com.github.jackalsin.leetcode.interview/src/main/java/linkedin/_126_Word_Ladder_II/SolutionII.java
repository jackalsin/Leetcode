package linkedin._126_Word_Ladder_II;

import java.util.*;

public final class SolutionII implements Solution {
  private final Map<String, Integer> distances = new HashMap<>();
  private final Map<String, Set<String>> neighbors = new HashMap<>();

  @Override
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    generateNeighbors(wordList, beginWord);
    bfsGenerateDistance(beginWord);
    final List<List<String>> result = new ArrayList<>();
    final List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    dfs(result, endWord, curPath, beginWord);
    return result;
  }

  private void dfs(final List<List<String>> result, final String endWord, final List<String> curPath,
                   final String beginWord) {
    if (!result.isEmpty() && result.get(0).size() < curPath.size()) {
      return;
    }
    if (beginWord.equals(endWord)) {
      if (result.isEmpty()) {
        result.add(new ArrayList<>(curPath));
        return;
      }
      if (result.get(0).size() > curPath.size()) {
        result.clear();
      }
      result.add(new ArrayList<>(curPath));
      return;
    }

    final Set<String> neighbors = this.neighbors.get(beginWord);

    for (final String n : neighbors) {
      if (distances.get(n) == curPath.size()) {
        curPath.add(n);
        dfs(result, endWord, curPath, n);
        curPath.remove(curPath.size() - 1);
      }
    }


  }

  private void generateNeighbors(List<String> wordList, String beginWord) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);

    for (String w : wordSet) {
      final Set<String> neighbors = new HashSet<>();
      this.neighbors.put(w, neighbors);
      final char[] chars = w.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; chr++) {
          if (chr == oldChar) continue;
          chars[i] = chr;
          final String newWord = String.valueOf(chars);
          if (wordSet.contains(newWord)) {
            neighbors.add(newWord);
          }
        }
        chars[i] = oldChar;
      }
    }
  }

  private void bfsGenerateDistance(String beginWord) {
    distances.put(beginWord, 0);
    final Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    int distance = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      distance++;
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        for (String n : neighbors.get(toRemove)) {
          if (!distances.containsKey(n)) {
            distances.put(n, distance);
            q.add(n);
          }
        }
      }
    }
  }

}
