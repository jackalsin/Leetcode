package airbnb.tenWizards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class MySolution implements Solution {

  @Override
  public List<Integer> getShortestPath(final List<List<Integer>> wizards, final int source, final int target) {
    final int n = wizards.size();
    final int[] parents = new int[n], dist = new int[n];
    // [next, cost]
    final TreeSet<Integer> pq = new TreeSet<>((x, y) -> Integer.compare(dist[x], dist[y]));
    Arrays.fill(parents, -1);
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    for (int i = 0; i < n; i++) {
      pq.add(i);
    }

    while (!pq.isEmpty()) {
      final int cur = pq.pollFirst(), curCost = dist[cur];
      final List<Integer> neighbors = wizards.get(cur);
      for (int c : neighbors) {
        final int nextCost = curCost + (cur - c) * (cur - c);
        if (nextCost > dist[c]) continue;
        pq.remove(c);
        parents[c] = cur;
        dist[c] = nextCost;
        pq.add(c);
      }
    }

    // generate path;
    final LinkedList<Integer> result = new LinkedList<>();
    int cur = target;
    while (cur != source) {
      result.addFirst(cur);
      cur = parents[cur];
    }
    result.addFirst(source);
    return result;
  }
}
