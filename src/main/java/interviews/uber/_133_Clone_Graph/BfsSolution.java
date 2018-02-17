package interviews.uber._133_Clone_Graph;

import utils.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public final class BfsSolution implements Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    final Map<Integer, UndirectedGraphNode> graph = new HashMap<>();
    final Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
    if (node == null) {
      return null;
    }
    queue.add(node);

    while (!queue.isEmpty()) {
      final UndirectedGraphNode toRemove = queue.remove(),
          toRemoveCopy = graph.getOrDefault(toRemove.label, new UndirectedGraphNode(toRemove.label));
      // add to graph
      graph.put(toRemoveCopy.label, toRemoveCopy);

      for (final UndirectedGraphNode neighbor : toRemove.neighbors) {
        final UndirectedGraphNode newNeighbor = graph.getOrDefault(
            neighbor.label, new UndirectedGraphNode(neighbor.label));
        if (!graph.containsKey(neighbor.label)) {
          queue.add(neighbor);
          graph.put(neighbor.label, newNeighbor);
        }
        toRemoveCopy.neighbors.add(newNeighbor);
      }
    }
    return graph.get(node.label);
  }
}
