package interviews.uber._133_Clone_Graph;

import utils.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DfsSolution implements Solution {
  private final Map<Integer, Node> graph = new HashMap<>();

  @Override
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    if (graph.containsKey(node.val)) {
      return graph.get(node.val);
    }
    final Node newNode = new Node(node.val, new ArrayList<>());
    graph.put(newNode.val, newNode);
    for (final Node neighbor : node.neighbors) {
      newNode.neighbors.add(cloneGraph(neighbor));
    }
    return newNode;
  }
}
