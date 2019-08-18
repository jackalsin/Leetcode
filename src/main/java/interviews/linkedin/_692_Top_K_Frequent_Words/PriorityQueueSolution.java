package interviews.linkedin._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/17/2019
 */
public final class PriorityQueueSolution implements Solution {
  @Override
  public List<String> topKFrequent(String[] words, int k) {
    final Map<String, Integer> wordCount = getWordCount(words);

    final Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        final int cmp = Integer.compare(o1.getValue(), o2.getValue());
        if (cmp == 0) {
          return o2.getKey().compareTo(o1.getKey());
        }
        return cmp;
      }
    });

    for (final Map.Entry<String, Integer> e : wordCount.entrySet()) {
      pq.add(e);
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

  private static Map<String, Integer> getWordCount(String[] words) {
    final Map<String, Integer> wordCounts = new HashMap<>();
    for (final String w : words) {
      wordCounts.put(w, wordCounts.getOrDefault(w, 0) + 1);
    }
    return wordCounts;
  }

}
