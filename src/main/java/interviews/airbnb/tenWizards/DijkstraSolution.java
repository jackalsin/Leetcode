package interviews.airbnb.tenWizards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class DijkstraSolution implements Solution {

  @Override
  public List<Integer> getShortestPath(final List<List<Integer>> wizards, final int source, final int target) {
    final int n = wizards.size();
    final int[] parents = new int[n], dist = new int[n];
    Arrays.fill(parents, -1);
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    final TreeSet<Integer> q = new TreeSet<>((x, y) -> Integer.compare(dist[x], dist[y]));
    for (int i = 0; i < n; i++) {
      q.add(i);
    }
    while (!q.isEmpty()) {
      final int cur = q.pollFirst(), curCost = dist[cur];
      final List<Integer> neighbors = wizards.get(cur);
      for (int nei : neighbors) {
        final int nextCost = curCost + (nei - cur) * (nei - cur);
        if (nextCost > dist[nei]) continue;
        q.remove(nei);
        dist[nei] = nextCost;
        parents[nei] = cur;
        q.add(nei);
      }
    }

    // form the path
    final LinkedList<Integer> path = new LinkedList<>();
    int cur = target;
    while (cur != source) {
      path.addFirst(cur);
      cur = parents[cur];
    }
    path.addFirst(cur);
    return path;
  }
}
