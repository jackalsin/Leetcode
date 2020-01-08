package interviews.uber._332_Reconstruct_Itinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
public final class SolutionI implements Solution {
  private static final String JFK = "JFK";
  private final Map<String, Queue<String>> map = new HashMap<>();
  private final LinkedList<String> result = new LinkedList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    for (final List<String> child : tickets) {
      map.computeIfAbsent(child.get(0), k -> new PriorityQueue<>()).add(child.get(1));
    }
    dfs(JFK);
    return result;
  }

  private void dfs(final String departure) {
    final Queue<String> nextStops = map.get(departure);
    while (nextStops != null && !nextStops.isEmpty()) {
      dfs(nextStops.remove());
    }
    result.addFirst(departure);
  }
}
