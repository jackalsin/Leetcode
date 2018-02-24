package interviews.uber._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MapSolution implements Solution {
  @Override
  public List<String> topKFrequent(String[] words, int k) {
    final Map<String, Integer> wordCounts = new HashMap<>();
    for (final String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }
    final Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int cmp = Integer.compare(o1.getValue(), o2.getValue());
        if (cmp == 0) {
          return o2.getKey().compareTo(o1.getKey());
        }
        return cmp;
      }
    });
    for (final Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
      queue.add(entry);
      if (queue.size() > k) {
        queue.remove();
      }
    }
    final LinkedList<String> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      result.addFirst(queue.remove().getKey());
    }
    return result;
  }
}
