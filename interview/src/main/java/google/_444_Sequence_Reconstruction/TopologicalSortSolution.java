package google._444_Sequence_Reconstruction;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class TopologicalSortSolution implements Solution {
  private final Map<Integer, Set<Integer>> preToChildren = new HashMap<>();
  private final Map<Integer, Integer> incomingLinks = new HashMap<>();
  private int total = 0;

  /**
   * Time complexity: org length is N, seqs length A * B
   * Generally, topological sort is O(Vertex) + O(Edge)
   */
  @Override
  public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    initGraph(seqs, org.length); // O(N) + O(AB)
    return solve(org); //
  }

  private boolean solve(int[] org) {
    if (total != org.length) {
      return false;
    }
    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= total; i++) {
      if (incomingLinks.get(i) == 0) {
        queue.add(i);
      }
    }
    final int[] res = new int[total];
    int i = 0;
    while (!queue.isEmpty()) {
      if (queue.size() != 1) {
        return false;
      }
      int toRemove = queue.remove();
      res[i++] = toRemove;
      final Set<Integer> children = preToChildren.get(toRemove);
      for (int child : children) {
        int prevCount = incomingLinks.get(child);
        incomingLinks.put(child, prevCount - 1);
        if (incomingLinks.get(child) == 0) {
          queue.add(child);
        }
      }
    }
    return i == incomingLinks.size() && i == org.length;
  }

  private void initGraph(List<List<Integer>> seqs, int size) {
    for (int i = 1; i <= size; i++) {
      incomingLinks.put(i, 0);
      preToChildren.put(i, new HashSet<>());
    }
    for (final List<Integer> edge : seqs) {
      if (edge.size() > 0) {
        total = Math.max(total, edge.get(0));
      }
      for (int i = 1; i < edge.size(); i++) {
        total = Math.max(total, edge.get(i));
        final Set<Integer> children = preToChildren.getOrDefault(edge.get(i - 1), new HashSet<>());
        if (children.add(edge.get(i))) {
          incomingLinks.put(edge.get(i), incomingLinks.getOrDefault(edge.get(i), 0) + 1);
        }
        preToChildren.put(edge.get(i - 1), children);
      }
    }
  }
}
