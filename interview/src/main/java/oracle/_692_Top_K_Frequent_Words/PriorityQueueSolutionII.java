package oracle._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class PriorityQueueSolutionII implements Solution {

  public List<String> topKFrequent(String[] words, int k) {
    final LinkedList<String> result = new LinkedList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    final Map<String, Integer> wordCount = getWordCount(words);
    final Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        final int countCmp = Integer.compare(o1.getValue(), o2.getValue());
        if (countCmp != 0) {
          return countCmp;
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

  private static Map<String, Integer> getWordCount(final String[] words) {
    final Map<String, Integer> result = new HashMap<>();
    for (final String word : words) {
      result.put(word, result.getOrDefault(word, 0) + 1);
    }
    return result;
  }
}
