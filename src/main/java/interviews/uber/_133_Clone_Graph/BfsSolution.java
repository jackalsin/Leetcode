package interviews.uber._133_Clone_Graph;

import utils._133_Clone_Graph.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public final class BfsSolution implements Solution {
  public Node cloneGraph(Node node) {
    final Map<Integer, Node> graph = new HashMap<>();
    final Queue<Node> queue = new ArrayDeque<>();
    if (node == null) {
      return null;
    }
    queue.add(node);

    while (!queue.isEmpty()) {
      final Node toRemove = queue.remove(),
          toRemoveCopy = graph.getOrDefault(toRemove.val, new Node(toRemove.val, new ArrayList<>()));
      // add to graph
      graph.put(toRemoveCopy.val, toRemoveCopy);

      for (final Node neighbor : toRemove.neighbors) {
        final Node newNeighbor = graph.getOrDefault(
            neighbor.val, new Node(neighbor.val, new ArrayList<>()));
        if (!graph.containsKey(neighbor.val)) {
          queue.add(neighbor);
          graph.put(neighbor.val, newNeighbor);
        }
        toRemoveCopy.neighbors.add(newNeighbor);
      }
    }
    return graph.get(node.val);
  }
}
