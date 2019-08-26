package interviews.linkedin._133_Clone_Graph;

import utils._133_Clone_Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/26/2019
 */
public final class MapSolution implements Solution {
  private final Map<Node, Node> cache = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    if (cache.containsKey(node)) {
      return cache.get(node);
    }
    final List<Node> neighbors = new ArrayList<>();
    final Node copy = new Node(node.val, neighbors);
    cache.put(node, copy);
    for (final Node dst : node.neighbors) {
      neighbors.add(cloneGraph(dst));
    }
    return copy;
  }
}
