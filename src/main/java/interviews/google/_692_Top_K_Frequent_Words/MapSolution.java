package interviews.google._692_Top_K_Frequent_Words;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
public final class MapSolution implements Solution {
  /**
   * 110 / 110 test cases passed.
   * Status: Accepted
   * Runtime: 89 ms
   */
  public List<String> topKFrequent(String[] words, int k) {
    final Map<String, Integer> wordCount = new HashMap<>();
    for (final String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    final Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((x, y) -> {
      // less frequency up, higher alphabetical up
      int cmp = Integer.compare(x.getValue(), y.getValue());
      if (cmp == 0) {
        return y.getKey().compareTo(x.getKey());
      }
      return cmp;
    });
    for (final Map.Entry<String, Integer> entry : wordCount.entrySet()) {
      pq.add(entry);
      if (pq.size() > k) {
        pq.remove();
      }
    }

    final LinkedList<String> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().getKey());
    }
    return result;
  }
}
