package _0101_0150._127_Word_Ladder;

import java.util.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/29/2017.
 */
public class Solution {

  /**
   * 39 / 39 test cases passed.
   * Status: Accepted
   * Runtime: 119 ms
   *
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    Map<String, Integer> distances = new HashMap<>();
    distances.put(beginWord, 1);
    Set<String> candidates = new HashSet<>(wordList);
    candidates.add(beginWord);
    int distance = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      distance++;
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        Set<String> neighbors = getNeighbors(word, candidates);
        for (String neighbor : neighbors) {
          if (!distances.containsKey(neighbor)) {
            queue.offer(neighbor);
            distances.put(neighbor, distance);
            if (neighbor.equals(endWord)) {
              return distance;
            }
          }
        }
      }
    }
    return 0;
  }

  private Set<String> getNeighbors(String word, Set<String> candidates) {
    Set<String> result = new HashSet<>();
    char chs[] = word.toCharArray();
    for (int i = 0; i < chs.length; i++) {
      char oldCh = chs[i];
      for (char ch = 'a'; ch <= 'z'; ch++) {
        chs[i] = ch;
        String newWord = String.valueOf(chs);
        if (candidates.contains(newWord)) {
          result.add(newWord);
        }
      }
      chs[i] = oldCh;
    }
    return result;
  }
}
