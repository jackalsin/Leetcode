package _0301_0350._332_Reconstruct_Itinerary;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 10/1/2017.
 */
public class Solution {

  public List<String> findItinerary(String[][] tickets) {
    Map<String, Queue<String>> fromToMapping = new HashMap<>();
    for (String[] it : tickets) {
      fromToMapping.putIfAbsent(it[0], new PriorityQueue<>());
      fromToMapping.get(it[0]).add(it[1]);
    }
    LinkedList<String> path = new LinkedList<>();
    dfs(fromToMapping, path, "JFK");
    return path;
  }

  private void dfs(final Map<String, Queue<String>> fromToMapping,
                   LinkedList<String> path, String depart) {
    Queue<String> arrivals = fromToMapping.get(depart);
    while (arrivals != null && !arrivals.isEmpty()) {
      dfs(fromToMapping, path, arrivals.poll());
    }
    path.addFirst(depart);

  }
}
