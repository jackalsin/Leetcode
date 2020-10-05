package linkedin._126_Word_Ladder_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class SolutionI implements Solution {
  private final Map<String, Integer> distances = new HashMap<>();
  private final Map<String, List<String>> neighbors = new HashMap<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    generateNeighbors(beginWord, wordList);
    bfsGenerateDistance(beginWord);
//    System.out.println(distances);
    final List<List<String>> result = new ArrayList<>();
    final List<String> curPath = new ArrayList<>();
    curPath.add(beginWord);
    dfs(result, endWord, beginWord, curPath);
    return result;
  }

  private void dfs(final List<List<String>> result, final String endWord, final String beginWord,
                   final List<String> curPath) {
    if (beginWord.equals(endWord)) {
//      System.out.println(curPath);
      if (result.isEmpty()) {
        result.add(new ArrayList<>(curPath));
        return;
      } else {
        if (result.get(0).size() < curPath.size()) {
          return;
        }
        if (result.get(0).size() > curPath.size()) {
          result.clear();
        }
        result.add(new ArrayList<>(curPath));
        return;
      }
    }
    final int depth = curPath.size();
    final List<String> neighbors = this.neighbors.get(beginWord);
    for (String n : neighbors) {
      if (distances.containsKey(n) && distances.get(n) == depth) {
        curPath.add(n);
        dfs(result, endWord, n, curPath);
        curPath.remove(curPath.size() - 1);
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
      for (int i = 0; i < size; ++i) {
        final String word = q.remove();
        final List<String> neighbors = this.neighbors.get(word);
        for (final String n : neighbors) {
          if (!distances.containsKey(n)) {
            distances.put(n, distance + 1);
            q.add(n);
          }
        }
      }
      ++distance;
    }
  }

  private void generateNeighbors(final String beginWord, List<String> wordList) {
    final Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);
    for (String word : wordSet) {
      neighbors.put(word, new ArrayList<>());
      final List<String> neighbors = this.neighbors.get(word);
      final char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        final char oldChar = chars[i];
        for (char chr = 'a'; chr <= 'z'; ++chr) {
          if (chr != oldChar) {
            chars[i] = chr;
            final String newWord = String.valueOf(chars);
            if (wordSet.contains(newWord)) {
              neighbors.add(newWord);
            }
          }
        }
        chars[i] = oldChar;
      }
    }
  }
}
