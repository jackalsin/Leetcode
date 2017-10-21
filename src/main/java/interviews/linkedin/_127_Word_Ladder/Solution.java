package interviews.linkedin._127_Word_Ladder;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/20/2017.
 */
public class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    Set<String> candidates = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
//    candidates.add(beginWord);
    int distance = 1;
    while (!queue.isEmpty()) {
      distance++;
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.remove();
        Set<String> neighbors = getNeighbors(word, candidates);
        for (String neighbor : neighbors) {
          if (!visited.contains(neighbor)) {
            queue.add(neighbor);
            visited.add(neighbor);
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
