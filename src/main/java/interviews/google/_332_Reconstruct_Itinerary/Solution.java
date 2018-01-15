package interviews.google._332_Reconstruct_Itinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class Solution {
  private static final String JFK = "JFK";

  public List<String> findItinerary(String[][] tickets) {
    final Map<String, PriorityQueue<String>> fromToTo = new HashMap<>();
    for (final String[] ticket : tickets) {
      fromToTo.putIfAbsent(ticket[0], new PriorityQueue<>());
      fromToTo.get(ticket[0]).add(ticket[1]);
    }
    final LinkedList<String> result = new LinkedList<>();
    dfs(fromToTo, result, JFK);
    return result;
  }

  private void dfs(final Map<String, PriorityQueue<String>> fromToTo, final LinkedList<String>
      result,
                   final String start) {
    final PriorityQueue<String> pq = fromToTo.get(start);
    while (pq != null && !pq.isEmpty()) {
      final String dest = pq.remove();
      dfs(fromToTo, result, dest);
    }
    result.addFirst(start);
  }

}
