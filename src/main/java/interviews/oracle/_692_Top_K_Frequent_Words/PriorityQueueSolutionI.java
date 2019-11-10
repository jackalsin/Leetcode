package interviews.oracle._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class PriorityQueueSolutionI implements Solution {
  @Override
  public List<String> topKFrequent(String[] words, int k) {
    final LinkedList<String> result = new LinkedList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    final Map<String, Integer> wordCount = new HashMap<>();
    for (final String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    final Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        final int cmp = Integer.compare(o1.getValue(), o2.getValue());
        if (cmp != 0) {
          return cmp;
        }
        return o2.getKey().compareTo(o1.getKey());
      }
    });
    for (final Map.Entry<String, Integer> e : wordCount.entrySet()) {
      pq.add(e);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().getKey());
    }
    return result;
  }
}
