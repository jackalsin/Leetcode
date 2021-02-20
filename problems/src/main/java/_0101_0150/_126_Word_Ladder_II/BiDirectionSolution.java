package _0101_0150._126_Word_Ladder_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/18/2021
 */
public final class BiDirectionSolution implements Solution {

  /**
   * The possible next word in a forward path.
   */
  private final Map<String, List<String>> neighbors = new HashMap<>();
  private final Set<String> wordSet = new HashSet<>();
  private final List<List<String>> result = new ArrayList<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    wordSet.addAll(wordList);
    if (!wordSet.contains(endWord)) {
      return result;
    }
    generateNeighbors(Set.of(beginWord), Set.of(endWord));
    final List<String> curPath = new ArrayList<>() {{
      add(beginWord);
    }};
    dfs(beginWord, endWord, curPath);
    return result;
  }

  private void dfs(final String begin, final String target, final List<String> curPath) {
    if (begin.equals(target)) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    final List<String> neighbors = this.neighbors.getOrDefault(begin, new ArrayList<>());
    for (final String neighbor : neighbors) {
      curPath.add(neighbor);
      dfs(neighbor, target, curPath);
      curPath.remove(curPath.size() - 1);
    }
  }

  private void generateNeighbors(Set<String> beginWord, Set<String> endWord) {
    boolean found = false;
    boolean isForward = true;
    while (!beginWord.isEmpty() && !endWord.isEmpty() && !found) {
      if (beginWord.size() > endWord.size()) {
        final Set<String> tmp = endWord;
        endWord = beginWord;
        beginWord = tmp;
        isForward = !isForward;
      }
//      System.out.println(beginWord + ", " + endWord);

      final Set<String> next = new HashSet<>();
      // 要提前移掉，不然 wordA和WordB都在beginWord里，且只差一个letter，可能会被计算到next中
      wordSet.removeAll(beginWord);
      for (final String cur : beginWord) {
        final char[] chars = cur.toCharArray();
        for (int i = 0; i < cur.length(); ++i) {
          final char oldChar = chars[i];
          for (char chr = 'a'; chr <= 'z'; chr++) {
            if (chr == oldChar) continue;
            chars[i] = chr;
            final String newWord = String.valueOf(chars);
            if (wordSet.contains(newWord)) {
              next.add(newWord);
              final String key = isForward ? cur : newWord,
                  value = isForward ? newWord : cur;
              neighbors.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
              if (endWord.contains(newWord)) {
                found = true;
              }
            }
          }
          chars[i] = oldChar;
        }
      }
      beginWord = next;
    }
  }
}
