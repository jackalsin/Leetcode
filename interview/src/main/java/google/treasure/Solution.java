package google.treasure;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class Solution {
  private final Graph graph;

  public Solution(Graph graph) {
    this.graph = graph;
  }

  public boolean canFind(final Room start) {
    final Queue<Room> queue = new ArrayDeque<>();
    queue.add(start);
    final Set<Edge> keySet = new HashSet<>(), lockedEdge = new HashSet<>();
    final Set<Room> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      final Room toRemove = queue.remove();
      if (toRemove.hasTreasure) {
        return true;
      }
      visited.add(toRemove);
      final Set<Edge> newKeys = toRemove.getKeys();
      keySet.addAll(newKeys);
      // unlock path
      for (final Edge edge : newKeys) {
        if (lockedEdge.contains(edge)) {
          if (!visited.contains(edge.to)) {
            queue.add(edge.to);
          }
        }
      }

      final Set<Edge> outcomingEdges = graph.getOutcomingEdges(toRemove);
      for (final Edge edge : outcomingEdges) {
        if (edge.needsKey) {
          if (keySet.contains(edge)) {
            if (!visited.contains(edge.to)) {
              queue.add(edge.to);
            }
          } else {
            lockedEdge.add(edge);
          }
        } else {
          if (!visited.contains(edge.to)) {
            queue.add(edge.to);
          }
        }
      }
    }

    return false;
  }

}
